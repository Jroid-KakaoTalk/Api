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
public class NpcChatLimitIntimacy {
    
    @EmbeddedId
    NpcChatLimitCurrentQuestPk pk;
    
    @Builder.Default
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer minIntimacy = 0;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED")
    Integer maxIntimacy;
    
}