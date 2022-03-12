package jroid.kakaotalk.server.entity.player;

import jroid.kakaotalk.server.entity.item.Plant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planted {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @Builder.Default
    @Column(nullable = false)
    LocalDateTime lastHarvestTime = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    Player player;
    
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    Plant plant;
    
}