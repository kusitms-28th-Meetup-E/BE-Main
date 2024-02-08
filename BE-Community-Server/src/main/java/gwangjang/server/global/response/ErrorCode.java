package gwangjang.server.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST("400", "입력값이 유효하지 않습니다."),
    METHOD_NOT_ALLOWED("405", "클라이언트가 사용한 HTTP 메서드가 리소스에서 허용되지 않습니다."),
    INTERNAL_SERVER_ERROR("500", "서버에서 요청을 처리하는 동안 오류가 발생했습니다."),
    NOT_FOUND_REFRESH_TOKEN_ERROR( "J0008",  "유효하지 않는 RefreshToken 입니다."),


    NOT_FOUND_COMMUNITY_ERROR("C001", "해당 커뮤니티 글을 찾을 수 없습니다"),
    NOT_FOUND_COMMENT_ERROR("CM001", "해당 댓글을 찾을 수 없습니다"),
    NOT_FOUND_HEART_ERROR("H001", "해당 좋아요 현황을 찾을 수 없습니다");

    private String errorCode;
    private String message;

}