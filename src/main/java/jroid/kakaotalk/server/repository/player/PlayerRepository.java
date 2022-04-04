package jroid.kakaotalk.server.repository.player;

import jroid.kakaotalk.server.entity.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerRepositoryCustom {
}
