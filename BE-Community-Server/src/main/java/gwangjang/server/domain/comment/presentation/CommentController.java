package gwangjang.server.domain.comment.presentation;

import gwangjang.server.domain.comment.application.dto.req.CommentReq;
import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.application.service.CommentCreateUseCase;
import gwangjang.server.domain.comment.application.service.CommentReadUseCase;
import gwangjang.server.domain.comment.presentation.constant.CommentResponseMessage;
import gwangjang.server.domain.community.application.dto.req.CommunityReq;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.service.CommunityCreateUseCase;
import gwangjang.server.domain.community.application.service.CommunityReadUseCase;
import gwangjang.server.domain.community.presentation.constant.CommunityResponseMessage;
import gwangjang.server.global.response.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/topic/{topicId}/community/{communityId}/comments")
public class CommentController {

    private final CommentCreateUseCase commentCreateUseCase;
    private final CommentReadUseCase commentReadUseCase;

    @PostMapping
    public ResponseEntity<SuccessResponse<List<CommentRes>>> createComment(@RequestHeader(value = "user-id") String socialId,
                                                                     @PathVariable("topicId") Long topicId,@PathVariable("communityId") Long communityId, @RequestBody CommentReq commentReq) {
        return ResponseEntity.ok(SuccessResponse.create(CommentResponseMessage.CREATE_COMMENT_SUCCESS.getMessage(), this.commentCreateUseCase.create(socialId, communityId, commentReq)));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<CommentRes>>> getComments(@RequestHeader(value = "user-id") String socialId,
                                                                         @PathVariable("topicId") Long topicId,@PathVariable("communityId") Long communityId) {
        return ResponseEntity.ok(SuccessResponse.create(CommentResponseMessage.GET_COMMENT_SUCCESS.getMessage(), this.commentReadUseCase.getCommentsByCommunity(communityId)));
    }
}
