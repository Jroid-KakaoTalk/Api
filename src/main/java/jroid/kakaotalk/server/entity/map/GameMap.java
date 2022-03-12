package jroid.kakaotalk.server.entity.map;

import jroid.kakaotalk.server.entity.entity.CreatedEntity;
import jroid.kakaotalk.server.entity.player.Player;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameMap {
    
    @Id
    @Column
    Integer location;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer requireLv;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer mapType;
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.gameMap", cascade = CascadeType.ALL)
    List<GameMapRespawn> gameMapRespawnList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "gameMap", cascade = CascadeType.ALL)
    List<GameMapField> gameMapFieldList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.gameMap", cascade = CascadeType.ALL)
    List<GameMapLimitQuest> gameMapLimitQuestList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "gameMap", cascade = CascadeType.ALL)
    List<Player> playerList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "baseGameMap", cascade = CascadeType.ALL)
    List<Player> basePlayerList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "gameMap", cascade = CascadeType.ALL)
    List<CreatedEntity> createdEntityList = new ArrayList<>();
    
}