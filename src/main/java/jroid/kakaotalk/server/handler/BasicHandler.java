package jroid.kakaotalk.server.handler;

import jroid.kakaotalk.server.dto.SocketOutput;
import jroid.kakaotalk.server.entity.player.Player;

import java.util.List;

public interface BasicHandler {
    
    SocketOutput handleMessage(List<String> data, Player player) throws RuntimeException;
    
}
