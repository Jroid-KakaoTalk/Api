package jroid.kakaotalk.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jroid.kakaotalk.server.dto.SocketInput;
import jroid.kakaotalk.server.dto.SocketOutput;
import jroid.kakaotalk.server.entity.GameLog;
import jroid.kakaotalk.server.entity.player.Player;
import jroid.kakaotalk.server.enums.LogType;
import jroid.kakaotalk.server.enums.SocketStatus;
import jroid.kakaotalk.server.exception.GameException;
import jroid.kakaotalk.server.handler.game.MineHandler;
import jroid.kakaotalk.server.repository.GameLogRepository;
import jroid.kakaotalk.server.repository.player.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    
    private final ObjectMapper mapper;
    private final GameLogRepository gameLogRepository;
    private final PlayerRepository playerRepository;
    
    private final Map<String, BasicHandler> handlerMap = new HashMap<>() {{
        put("mine", new MineHandler());
    }};
    
    @Override
    @Transactional
    protected void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage textMessage) throws Exception {
        SocketInput input;
        String message;
        String sender;
        String image;
        
        Player player = null;
        
        try {
            input = mapper.readValue(textMessage.getPayload(), SocketInput.class);
            message = input.getMessage().trim();
            sender = input.getSender().trim();
            image = input.getImage().trim();
            
            //에러 발생 시 어짜피 return
            if(
                message.length() > 255 || sender.length() < 1 || sender.length() > 255 ||
                    image.length() < 1 || image.length() > 255
            ) {
                return;
            }
            
            if(!StringUtils.hasLength(input.getMethod())) {
                gameLogRepository.save(
                    GameLog.builder()
                        .logType(LogType.MISSING_ARG.getValue())
                        .log(message)
                        .sender(sender)
                        .image(image)
                        .build()
                );
                return;
            }
        } catch(Exception e) {
            return;
        }
    
        SocketOutput commonOutput = SocketOutput
            .builder()
            .sender(sender)
            .image(image)
            .build();
        
        try {
            player = getPlayer(sender, image);
            
            BasicHandler handler = handlerMap.get(input.getMethod());
            if(handler != null) {
                SocketOutput output = handler.handleMessage(input.getData(), player);
                if(output != null) {
                    sendMessage(session, output);
                    return;
                }
            }
    
            commonOutput.setStatus(SocketStatus.IGNORE.getValue());
            sendMessage(session, commonOutput);
        } catch(Exception e) {
            commonOutput.setStatus(SocketStatus.ERROR.getValue());
            sendMessage(session, commonOutput);
            
            LogType logType = LogType.ERROR;
            if(e instanceof GameException) {
                logType = ((GameException) e).getLogType();
            }
            
            gameLogRepository.save(
                GameLog.builder()
                    .logType(logType.getValue())
                    .log(e.getMessage())
                    .sender(sender)
                    .image(image)
                    .player(player)
                    .build()
            );
        }
    }
    
    private void sendMessage(@NonNull WebSocketSession session, @NonNull SocketOutput socketOutput) throws Exception {
        session.sendMessage(new TextMessage(
            mapper.writeValueAsString(socketOutput)
        ));
    }
    
    @Transactional(readOnly = true)
    @Cacheable(value = "player", key = "#sender + #image")
    public Player getPlayer(@NonNull String sender, @NonNull String image) {
        return playerRepository.findPlayer(sender, image);
    }
    
}
