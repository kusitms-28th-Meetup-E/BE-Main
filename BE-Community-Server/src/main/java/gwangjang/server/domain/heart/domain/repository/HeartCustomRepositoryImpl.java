package gwangjang.server.domain.heart.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.domain.entity.Heart;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static gwangjang.server.domain.heart.domain.entity.QHeart.heart;

public class HeartCustomRepositoryImpl implements HeartCustomRepository {


    private final JPAQueryFactory queryFactory;

    public HeartCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    public Optional<HeartRes> findHeartByPusherIdAndCommunityId(String pusherId,Long communityId) {
        return Optional.ofNullable(queryFactory
                .select(Projections.constructor(HeartRes.class,
                        heart.pusherId,
                        heart.community.id,
                        heart.status
                ))
                .from(heart)
                .where(
                        heart.pusherId.eq(pusherId),
                        heart.community.id.eq(communityId)
                )
                .fetchFirst()
        );
    }

    public Optional<List<HeartRes>> findAllHeartByPusherIdAndCommunityId(String pusherId, Long communityId) {
        return Optional.ofNullable(queryFactory
                .select(Projections.constructor(HeartRes.class,
                        heart.pusherId,
                        heart.community.id,
                        heart.status
                ))
                .from(heart)
                .where(
                        heart.pusherId.eq(pusherId),
                        heart.community.id.eq(communityId)
                )
                .orderBy(heart.community.createdAt.desc())
                .fetch()
        );
    }


    public Optional<Heart> findHeartById(String pusherId, Long communityId) {
        return Optional.ofNullable(queryFactory
                .select(heart)
                .from(heart)
                .where(
                        heart.pusherId.eq(pusherId),
                        heart.community.id.eq(communityId)
                )
                .fetchFirst()
        );
    }


}
