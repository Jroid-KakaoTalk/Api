package jroid.kakaotalk.server.entity.item;

import jroid.kakaotalk.server.entity.living.LivingItemUnique;
import jroid.kakaotalk.server.entity.map.GameMapFieldItem;
import jroid.kakaotalk.server.entity.npc.NpcShop;
import jroid.kakaotalk.server.entity.npc.NpcShopSimple;
import jroid.kakaotalk.server.entity.quest.QuestNeedItem;
import jroid.kakaotalk.server.entity.quest.QuestRewardItem;
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
public class Item {
    
    @Id
    @Column
    Long id;
    
    @Column(nullable = false, length = 63)
    String des;
    
    @Column(length = 63)
    String gainDes;
    
    @Column(length = 63)
    String useDes;
    
    @Column(length = 63)
    String eatDes;
    
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    Plant plant;
    
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<ItemBuffStat> itemBuffStatList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "rewardItem", cascade = CascadeType.ALL)
    List<Plant> plantRewardList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<LivingItemUnique> livingItemUniqueList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<ItemRecipe> itemRecipeList1 = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "recipeItem", cascade = CascadeType.ALL)
    List<ItemRecipe> itemRecipeList2 = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "recipeItem", cascade = CascadeType.ALL)
    List<EquipRecipe> equipRecipeList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.item", cascade = CascadeType.ALL)
    List<GameMapFieldItem> gameMapFieldItemList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<NpcShop> npcShopList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<NpcShopSimple> npcShopSimpleList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.item", cascade = CascadeType.ALL)
    List<QuestNeedItem> questNeedItemList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.item", cascade = CascadeType.ALL)
    List<QuestRewardItem> questRewardItemList = new ArrayList<>();
    
}