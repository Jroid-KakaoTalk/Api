package jroid.kakaotalk.server.entity.entity;

import jroid.kakaotalk.server.entity.player.Player;
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
public class CreatedEntityAngryPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "created_entity_id")
    CreatedEntity createdEntity;
    
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    
    @Override
    public int hashCode() {
        return createdEntity.id.hashCode() ^ player.getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof CreatedEntityAngryPk) {
            CreatedEntityAngryPk pk = (CreatedEntityAngryPk) obj;
            return createdEntity.id.equals(pk.createdEntity.id) &&
                player.getId().equals(pk.player.getId());
        } else {
            return false;
        }
    }
    
}