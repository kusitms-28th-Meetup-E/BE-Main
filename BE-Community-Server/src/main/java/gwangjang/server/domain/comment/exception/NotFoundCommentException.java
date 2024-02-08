package gwangjang.server.domain.comment.exception;

import gwangjang.server.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotFoundCommentException extends CommentException {

    public NotFoundCommentException() {
        super(ErrorCode.NOT_FOUND_COMMUNITY_ERROR, HttpStatus.NOT_FOUND);
    }
}
