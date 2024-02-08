package gwangjang.server.domain.community.presentation.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommunityResponseMessage {


    CREATE_COMMUNITY_SUCCESS("커뮤니티 글 작성을 완료 했습니다"),
    GET_COMMUNITY_SUCCESS("커뮤니티 글 조회를 완료 했습니다");

    private final String message;

}
