package jroid.kakaotalk.server.entity;

import jroid.kakaotalk.server.entity.entity.CreatedEntity;
import jroid.kakaotalk.server.entity.player.Player;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @CreationTimestamp
    @Column(nullable = false)
    LocalDateTime created;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED NOT NULL")
    Integer logType;
    
    @Column(nullable = false)
    String log;
    
    @ManyToOne
    @JoinColumn
    Player player;
    
    @ManyToOne
    @JoinColumn
    CreatedEntity createdEntity;
    
}