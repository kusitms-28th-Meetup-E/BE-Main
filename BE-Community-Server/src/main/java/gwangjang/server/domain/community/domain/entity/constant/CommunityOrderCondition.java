package gwangjang.server.domain.community.domain.entity.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommunityOrderCondition {
    TOPIC("topic"),ISSUE("issue"), KEYWORD("keyword"),ALL("all"),SEARCH("search");
    private final String name;
}
