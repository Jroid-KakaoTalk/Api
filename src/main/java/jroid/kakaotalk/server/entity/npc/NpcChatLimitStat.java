package jroid.kakaotalk.server.entity.npc;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NpcChatLimitStat {
    
    @EmbeddedId
    NpcChatLimitStatPk pk;
    
    @Builder.Default
    @Column(nullable = false)
    Integer minStat = 0;
    
    @Column
    Integer maxStat;
    
}