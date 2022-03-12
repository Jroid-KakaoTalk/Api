package jroid.kakaotalk.server.handler;

import jroid.kakaotalk.server.dto.SocketInput;
import jroid.kakaotalk.server.dto.SocketOutput;
import org.springframework.lang.NonNull;

public interface BasicHandler {
    
    SocketOutput handleMessage(@NonNull SocketInput input) throws Exception;
    
}
