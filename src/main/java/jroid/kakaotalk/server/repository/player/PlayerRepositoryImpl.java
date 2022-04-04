package jroid.kakaotalk.server.repository.player;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jroid.kakaotalk.server.entity.player.Player;
import jroid.kakaotalk.server.enums.LogType;
import jroid.kakaotalk.server.exception.GameException;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import static jroid.kakaotalk.server.entity.player.QPlayer.player;

@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    
    @Override
    public Player findPlayer(@NonNull String sender, @NonNull String image) {
        Player foundPlayer = queryFactory
            .selectFrom(player)
            .where(player.sender.eq(sender).and(player.image.eq(image)))
            .fetchOne();
        
        if(foundPlayer == null) {
            throw GameException.builder()
                .logType(LogType.OBJECT_NOT_FOUND)
                .build();
        }
        
        return foundPlayer;
    }
    
}
