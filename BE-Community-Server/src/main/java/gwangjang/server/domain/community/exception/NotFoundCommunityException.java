package gwangjang.server.domain.community.exception;

import gwangjang.server.global.response.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotFoundCommunityException extends CommunityException {

    public NotFoundCommunityException() {
        super(ErrorCode.NOT_FOUND_COMMUNITY_ERROR, HttpStatus.NOT_FOUND);
    }
}
