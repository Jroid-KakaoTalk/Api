package jroid.kakaotalk.server.repository.player;

import jroid.kakaotalk.server.entity.player.Player;
import org.springframework.lang.NonNull;

public interface PlayerRepositoryCustom {
    
    Player findPlayer(@NonNull String sender, @NonNull String image);
    
}
