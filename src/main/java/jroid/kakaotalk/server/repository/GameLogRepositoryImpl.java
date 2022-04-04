package jroid.kakaotalk.server.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameLogRepositoryImpl implements GameLogRepositoryCustom {

    private final JPAQueryFactory queryFactory;

}
