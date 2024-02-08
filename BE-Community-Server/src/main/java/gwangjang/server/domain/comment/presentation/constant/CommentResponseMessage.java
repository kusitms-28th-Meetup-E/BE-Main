package gwangjang.server.domain.comment.presentation.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum CommentResponseMessage {


    CREATE_COMMENT_SUCCESS("댓글 작성을 완료했습니다."),
    GET_COMMENT_SUCCESS("댓글 조회를 완료했습니다.");


    private final String message;

}