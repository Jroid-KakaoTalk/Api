package jroid.kakaotalk.server.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SocketInput {
    
    private String method;
    private String sender;
    private String image;
    private String message;
    private List<String> data;
    
}
