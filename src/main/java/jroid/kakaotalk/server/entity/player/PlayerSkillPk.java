package jroid.kakaotalk.server.entity.player;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSkillPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    
    @ManyToOne
    @JoinColumn(name = "skill_id")
    Skill skill;
    
    @Override
    public int hashCode() {
        return player.id.hashCode() ^ skill.id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof PlayerSkillPk) {
            PlayerSkillPk pk = (PlayerSkillPk) obj;
            return player.id.equals(pk.player.id) &&
                skill.id.equals(pk.skill.id);
        } else {
            return false;
        }
    }
    
}