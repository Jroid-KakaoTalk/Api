package jroid.kakaotalk.server.entity.living;

import jroid.kakaotalk.server.entity.entity.CreatedEntity;
import jroid.kakaotalk.server.entity.item.Item;
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
public class LivingItemUnique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
    
    @ManyToOne
    @JoinColumn(name = "created_entity_id")
    CreatedEntity createdEntity;
    
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    Item item;
    
    @Builder.Default
    @OneToMany(mappedBy = "living", cascade = CascadeType.ALL)
    List<LivingItem> livingItemList = new ArrayList<>();
    
}
