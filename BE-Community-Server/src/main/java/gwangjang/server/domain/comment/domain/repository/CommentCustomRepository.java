package gwangjang.server.domain.comment.domain.repository;

import gwangjang.server.domain.comment.application.dto.res.CommentRes;

import java.util.List;

public interface CommentCustomRepository {

    List<CommentRes> findCommentsByCommunityId(Long communityId);

}
