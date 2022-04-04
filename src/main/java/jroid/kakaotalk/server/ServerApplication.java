package jroid.kakaotalk.server;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@EnableCaching
@SpringBootApplication
public class ServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    
    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
    
}
