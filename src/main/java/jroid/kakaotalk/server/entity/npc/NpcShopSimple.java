package jroid.kakaotalk.server.entity.npc;

import jroid.kakaotalk.server.entity.item.Equipment;
import jroid.kakaotalk.server.entity.item.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NpcShopSimple {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @Column(nullable = false, length = 63)
    String simple;
    
    @ManyToOne
    @JoinColumn(name = "npc_shop_id", nullable = false)
    NpcShop npcShop;
    
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    Item item;
    
    @ManyToOne
    @JoinColumn(name = "equip_id", nullable = false)
    Equipment equipment;
    
}