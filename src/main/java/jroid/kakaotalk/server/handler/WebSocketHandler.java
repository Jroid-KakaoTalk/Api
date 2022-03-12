package jroid.kakaotalk.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jroid.kakaotalk.server.dto.SocketInput;
import jroid.kakaotalk.server.dto.SocketOutput;
import jroid.kakaotalk.server.handler.game.MineHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, BasicHandler> handlerMap = new HashMap<>() {{
        put("mine", new MineHandler());
    }};
    
    @Override
    protected void handleTextMessage(
        @NonNull WebSocketSession session, @NonNull TextMessage message
    ) throws Exception {
        try {
            SocketInput input = mapper.readValue(message.getPayload(), SocketInput.class);
            BasicHandler handler = handlerMap.get(input.getMethod());
            
            if(handler != null) {
                SocketOutput output = handler.handleMessage(input);
                
                if(output != null) {
                    sendMessage(session, output);
                }
            }
        } catch(Exception e) {
            sendMessage(
                session,
                SocketOutput.builder()
                    .message(e.getMessage())
                    .status(500)
                    .build()
            );
        }
    }
    
    private void sendMessage(@NonNull WebSocketSession session, @NonNull SocketOutput socketOutput) throws Exception {
        session.sendMessage(new TextMessage(
            mapper.writeValueAsString(socketOutput)
        ));
    }
    
}
