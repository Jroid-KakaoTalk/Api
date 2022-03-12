package jroid.kakaotalk.server.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class SocketOutput {
    
    @Builder.Default
    int status = 1;
    
    @Builder.Default
    String message = "Success";
    
    @Builder.Default
    Map<String, Object> result = new HashMap<>();
    
}
