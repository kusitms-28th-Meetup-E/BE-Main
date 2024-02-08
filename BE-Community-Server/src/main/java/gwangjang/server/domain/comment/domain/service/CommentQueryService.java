package gwangjang.server.domain.comment.domain.service;

import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.domain.repository.CommentRepository;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class CommentQueryService {

    private final CommentRepository commentRepository;

    public List<CommentRes> getCommentsByCommunityId(Long communityId) {
        return commentRepository.findCommentsByCommunityId(communityId);
    }



}
