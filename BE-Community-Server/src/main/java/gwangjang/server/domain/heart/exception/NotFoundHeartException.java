package gwangjang.server.domain.heart.exception;

import gwangjang.server.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotFoundHeartException extends HeartException {

    public NotFoundHeartException() {
        super(ErrorCode.NOT_FOUND_HEART_ERROR, HttpStatus.NOT_FOUND);
    }
}
