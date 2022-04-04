package jroid.kakaotalk.server.dto;

import jroid.kakaotalk.server.enums.SocketStatus;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class SocketOutput {
    
    @Builder.Default
    int status = SocketStatus.SUCCESS.getValue();
    
    String message;
    
    String sender;
    
    String image;
    
    @Builder.Default
    Map<String, Object> data = new HashMap<>();
    
}
