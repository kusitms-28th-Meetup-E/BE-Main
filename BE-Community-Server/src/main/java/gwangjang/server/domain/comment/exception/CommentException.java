package gwangjang.server.domain.comment.exception;

import gwangjang.server.global.exception.ApplicationException;
import gwangjang.server.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class CommentException extends ApplicationException {

    protected CommentException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }
}
