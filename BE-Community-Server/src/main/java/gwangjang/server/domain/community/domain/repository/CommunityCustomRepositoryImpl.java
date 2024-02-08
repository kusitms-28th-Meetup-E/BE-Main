package gwangjang.server.domain.community.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.entity.QCommunity;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static gwangjang.server.domain.community.domain.entity.QCommunity.community;
import static gwangjang.server.domain.heart.domain.entity.QHeart.heart;

public class CommunityCustomRepositoryImpl implements CommunityCustomRepository {

    private final JPAQueryFactory queryFactory;

    public CommunityCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<List<CommunityRes>> findAllCommunityByTopic(String memberId,String topic) {

        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId,
                                memberHeartExists

                        ))
                        .from(community)
                        .where(community.topic.eq(topic))
                        .orderBy(community.createdAt.desc())
                        .fetch()
        );
    }
    @Override
    public Optional<List<CommunityRes>> findAllCommunity(String memberId) {

        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId,
                                memberHeartExists
                        ))
                        .from(community)
                        .orderBy(community.createdAt.desc())
                        .fetch()
        );
    }

    @Override
    public Optional<CommunityRes> findCommunity(String memberId,Long communityId) {
        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        return Optional.ofNullable(
                queryFactory
                        .select(Projections.constructor(CommunityRes.class,
                                community.id,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId,
                                memberHeartExists
                        ))
                        .from(community)
                        .where(community.id.eq(communityId))
                        .fetchFirst()
        );
    }

    @Override
    public Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndTopic(String memberId,String topic) {

        return Optional.empty();
    }

    @Override
    public Optional<List<CommunityRes>> findCommunityTop5(String memberId,CommunityOrderCondition orderCondition, String word) {

        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        return Optional.ofNullable(queryFactory
                .select(Projections.constructor(CommunityRes.class,
                        community.id,
                        community.talk,
                        community.createdAt,
                        community.writerId,
                        community.topic,
                        community.issue,
                        community.keyword,
                        community.hearts.size().longValue(),
                        community.comments.size().longValue(),
                        community.contentsId,
                        memberHeartExists
                ))
                .from(community)
                .where(
                        orderByColumn(orderCondition,word)

                ).orderBy(community.hearts.size().desc()) // hearts의 크기에 따라 내림차순 정렬
                .limit(5) // 상위 5개 결과만 선택
                .fetch());


    }

    @Override
    public Optional<List<CommunityRes>> findCommunityByMyHearts(String memberId) {
        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        JPQLQuery<Community> heartsQuery = JPAExpressions
                .select(heart.community)
                .from(heart)
                .where(
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE));

        return Optional.ofNullable(queryFactory.select(
                Projections.constructor(CommunityRes.class,
                        community.id,
                        community.talk,
                        community.createdAt,
                        community.writerId,
                        community.topic,
                        community.issue,
                        community.keyword,
                        community.hearts.size().longValue(),
                        community.comments.size().longValue(),
                        community.contentsId,
                        memberHeartExists
                        ))
                        .from(community)
                        .where(community.in(heartsQuery))

//                        .orderBy(community.hearts.size().desc()) // hearts의 크기에 따라 내림차순 정렬
                        .fetch());

    }


    private BooleanExpression orderByColumn(CommunityOrderCondition orderCondition, String word) {
        if (orderCondition.equals(CommunityOrderCondition.KEYWORD)) {
            return community.keyword.eq(word);
        } else if (orderCondition.equals(CommunityOrderCondition.ISSUE)) {
            return community.issue.eq(word);
        } else if (orderCondition.equals(CommunityOrderCondition.ALL)) {
            return null;
        } else if (orderCondition.equals(CommunityOrderCondition.SEARCH)) {
            return community.topic.like("%"+word+"%").or(community.issue.like("%"+word+"%")
                    .or(community.keyword.like("%"+word+"%").or(community.talk.like("%"+word+"%"))));
        } else{
            return community.topic.eq(word);
        }
    }

    public Optional<List<CommunityRes>> findCommunityByMyId(String memberId) {

        BooleanExpression memberHeartExists = JPAExpressions
                .selectOne()
                .from(heart)
                .where(
                        heart.community.id.eq(community.id),
                        heart.pusherId.eq(memberId),
                        heart.status.eq(Boolean.TRUE))
                .exists();

        return Optional.ofNullable(queryFactory.select(
                        Projections.constructor(CommunityRes.class,
                                community.id,
                                community.talk,
                                community.createdAt,
                                community.writerId,
                                community.topic,
                                community.issue,
                                community.keyword,
                                community.hearts.size().longValue(),
                                community.comments.size().longValue(),
                                community.contentsId,
                                memberHeartExists
                        ))
                .from(community)
                .where(community.writerId.eq(memberId))
                .fetch());
    }

    public Optional<List<CommunityRes>> getSearchCommunity (String memberId, CommunityOrderCondition orderCondition, String keyword){

            BooleanExpression memberHeartExists = JPAExpressions
                    .selectOne()
                    .from(heart)
                    .where(
                            heart.community.id.eq(community.id),
                            heart.pusherId.eq(memberId),
                            heart.status.eq(Boolean.TRUE))
                    .exists();

            return Optional.ofNullable(queryFactory
                    .select(Projections.constructor(CommunityRes.class,
                            community.id,
                            community.talk,
                            community.createdAt,
                            community.writerId,
                            community.topic,
                            community.issue,
                            community.keyword,
                            community.hearts.size().longValue(),
                            community.comments.size().longValue(),
                            community.contentsId,
                            memberHeartExists
                    ))
                    .from(community)
                    .where(
                            orderByColumn(orderCondition, keyword)

                    ).orderBy(community.hearts.size().desc()) // hearts의 크기에 따라 내림차순 정렬
                    .fetch());

        }



}
