package jroid.kakaotalk.server.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SocketInput {
    
    String method;
    Map<String, Object> data;
    
}
