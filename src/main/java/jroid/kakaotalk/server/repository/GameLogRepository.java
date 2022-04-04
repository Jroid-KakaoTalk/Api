package jroid.kakaotalk.server.repository;

import jroid.kakaotalk.server.entity.GameLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameLogRepository extends JpaRepository<GameLog, Long>, GameLogRepositoryCustom {
}
