package jroid.kakaotalk.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
    
    @Id
    @GeneratedValue
    @Column
    Long id;
    
}
