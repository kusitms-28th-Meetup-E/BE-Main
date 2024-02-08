package gwangjang.server.domain.heart.application.dto.res;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeartRes {
    private String pusherId;
    private Long communityId;
    private String status;
}
