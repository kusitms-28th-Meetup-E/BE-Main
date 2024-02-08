package gwangjang.server.domain.comment.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import jakarta.persistence.EntityManager;

import java.util.List;

import static gwangjang.server.domain.comment.domain.entity.QComment.comment;


public class CommentCustomRepositoryImpl implements CommentCustomRepository {


    private final JPAQueryFactory queryFactory;

    public CommentCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    public List<CommentRes> findCommentsByCommunityId(Long communityId) {
        return queryFactory
                .select(Projections.constructor(CommentRes.class,
                        comment.talk,
                        comment.createdAt.stringValue(),
                        comment.writerId
                ))
                .from(comment)
                .where(comment.community.id.eq(communityId))
                .orderBy(comment.createdAt.desc())
                .fetch();
    }

}
