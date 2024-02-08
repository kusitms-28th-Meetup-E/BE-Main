package gwangjang.server.domain.heart.presentation.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HeartCommunityResponse {


    PUSH_HEART_SUCCESS("게시글 좋아요/취소 를 완료 했습니다."),
    GET_COMMUNITY_SUCCESS("커뮤니티 글 조회를 완료 했습니다");

    private final String message;

}
