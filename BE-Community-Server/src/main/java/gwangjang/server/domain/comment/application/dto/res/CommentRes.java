package gwangjang.server.domain.comment.application.dto.res;

import gwangjang.server.domain.community.application.dto.res.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRes {

    private String talk;
    private String createAt;
    private String writerId;
    private String nickname;
    private String profileImg;

    public CommentRes(String talk, String createAt, String writerId) {
        this.talk = talk;
        this.createAt = createAt;
        this.writerId = writerId;
    }

    public void updateWriterInfo(MemberDto memberDto) {
        this.nickname = memberDto.getNickname();
        this.profileImg = memberDto.getProfileImage();
    }
}

