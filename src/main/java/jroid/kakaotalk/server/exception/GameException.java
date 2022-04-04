package jroid.kakaotalk.server.exception;

import jroid.kakaotalk.server.enums.LogType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GameException extends RuntimeException {
    
    private LogType logType;
    
}
