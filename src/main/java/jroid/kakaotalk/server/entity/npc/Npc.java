package jroid.kakaotalk.server.entity.npc;

import jroid.kakaotalk.server.entity.chat.Chat;
import jroid.kakaotalk.server.entity.chat.ChatAnyResponse;
import jroid.kakaotalk.server.entity.chat.ChatResponse;
import jroid.kakaotalk.server.entity.quest.Quest;
import jroid.kakaotalk.server.entity.quest.QuestNeedIntimacy;
import jroid.kakaotalk.server.entity.quest.QuestRewardIntimacy;
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
public class Npc {
    
    @Id
    @Column
    Long id;
    
    @Builder.Default
    @Column(nullable = false)
    Integer location = 0x01010101;
    
    @ManyToOne
    @JoinColumn(name = "first_chat_id", nullable = false)
    Chat firstChat;
    
    @Builder.Default
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    List<Quest> questList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    List<ChatResponse> chatResponseList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    List<ChatAnyResponse> chatAnyResponseList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    List<NpcChat> npcChatList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "npc", cascade = CascadeType.ALL)
    List<NpcShop> npcShopList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.npc", cascade = CascadeType.ALL)
    List<QuestNeedIntimacy> questNeedIntimacyList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.npc", cascade = CascadeType.ALL)
    List<QuestRewardIntimacy> questRewardIntimacyList = new ArrayList<>();
    
}