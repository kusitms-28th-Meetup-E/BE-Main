package gwangjang.server.domain.comment.application.service;

import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.domain.service.CommentQueryService;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.global.feign.client.FindMemberFeignClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentReadUseCase {

    private final CommentQueryService commentQueryService;
    private final FindMemberFeignClient findMemberFeignClient;

    public List<CommentRes> getCommentsByCommunity(Long communityId) {
        List<CommentRes> comments = commentQueryService.getCommentsByCommunityId(communityId);

        comments.stream().forEach(
                commentRes -> {
                    String writerId = commentRes.getWriterId();
                    MemberDto memberDto = findMemberFeignClient.getMemberBySocialId(writerId);
                    commentRes.updateWriterInfo(memberDto);
                }
        );
        return comments;
    }

}
