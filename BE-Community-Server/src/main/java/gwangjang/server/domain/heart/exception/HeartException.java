package gwangjang.server.domain.heart.exception;

import gwangjang.server.global.exception.ApplicationException;
import gwangjang.server.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class HeartException extends ApplicationException {

    protected HeartException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode, httpStatus);
    }
}
