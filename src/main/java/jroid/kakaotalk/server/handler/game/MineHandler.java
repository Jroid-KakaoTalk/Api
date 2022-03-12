package jroid.kakaotalk.server.handler.game;

import jroid.kakaotalk.server.dto.SocketInput;
import jroid.kakaotalk.server.dto.SocketOutput;
import jroid.kakaotalk.server.handler.BasicHandler;
import org.springframework.lang.NonNull;

public class MineHandler implements BasicHandler {
    
    @Override
    public SocketOutput handleMessage(@NonNull SocketInput input) throws Exception {
        return SocketOutput.builder()
            .build();
    }
    
}
