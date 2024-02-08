package gwangjang.server.domain.comment.application.service;

import gwangjang.server.domain.comment.application.dto.req.CommentReq;
import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.application.mapper.CommentMapper;
import gwangjang.server.domain.comment.domain.entity.Comment;
import gwangjang.server.domain.comment.domain.service.CommentQueryService;
import gwangjang.server.domain.comment.domain.service.CommentSaveService;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.service.CommunityQueryService;
import gwangjang.server.global.feign.client.FindMemberFeignClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentCreateUseCase {

    private final CommentSaveService commentSaveService;
    private final CommentQueryService commentQueryService;
    private final CommunityQueryService communityQueryService;
    private final CommentReadUseCase commentReadUseCase;


    private final FindMemberFeignClient findMemberFeignClient;


    private final CommentMapper commentMapper = new CommentMapper();

    public List<CommentRes> create(String socialId, Long communityId, CommentReq commentReq) {

        MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(socialId);
        Community community = communityQueryService.getCommunityById(communityId);

        Comment comment = commentSaveService.save(commentMapper.mapToComment(socialId, community, commentReq));
        community.updateComments(comment);

        return commentReadUseCase.getCommentsByCommunity(communityId);
//        return commentMapper.mapToCommentRes(memberDto, comment);

    }
}
