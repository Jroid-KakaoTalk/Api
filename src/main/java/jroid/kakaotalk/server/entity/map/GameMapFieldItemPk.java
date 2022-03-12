package jroid.kakaotalk.server.entity.map;

import jroid.kakaotalk.server.entity.item.Item;
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
public class GameMapFieldItemPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "field_location")
    GameMapField gameMapField;
    
    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;
    
    @Override
    public int hashCode() {
        return gameMapField.gameMap.location.hashCode() ^ item.getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof GameMapFieldItemPk) {
            GameMapFieldItemPk pk = (GameMapFieldItemPk) obj;
            return gameMapField.gameMap.location.equals(pk.gameMapField.gameMap.location) &&
                item.getId().equals(pk.item.getId());
        } else {
            return false;
        }
    }
    
}