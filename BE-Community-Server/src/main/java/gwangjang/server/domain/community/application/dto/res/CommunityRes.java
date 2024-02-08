package gwangjang.server.domain.community.application.dto.res;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityRes {

    private Long id;
    private String communityText;
    private String date;

    private String writerId;
    private String nickname;
    private String profileImg;

    private String area;
    private String subject;
    private String keyword;

    private Long likeCount;
    private Long commentCount;

    private Long contentsId;
    private String contents;
    private String contentsTitle;
    private String contentsUrl;

    private Boolean likeStatus;

    public CommunityRes(Long id, String talk, LocalDateTime date, String writerId,
                        String topic, String issue, String keyword, Long heartsNum, Long commentsNum,Long contentsId, Boolean likeStatus) {
        this.id = id;
        this.communityText = talk;
        this.date = date.toString();
        this.writerId = writerId;
        this.area = topic;
        this.subject = issue;
        this.keyword = keyword;
        this.likeCount = heartsNum;
        this.commentCount = commentsNum;
        this.contentsId = contentsId;
        this.likeStatus = likeStatus;
    }

    public CommunityRes(String nickname, String profileImg) {
        this.nickname = nickname;
        this.profileImg = profileImg;
    }

    public void updateMemberDto(MemberDto memberDto) {
        this.nickname = memberDto.getNickname();
        this.profileImg = memberDto.getProfileImage();
    }

    public void updateContentsDto(ContentsDto contentsDto) {
        this.area = contentsDto.getTopic();
        this.subject = contentsDto.getIssueTitle();
        this.keyword = contentsDto.getKeyword();
        this.contents = contentsDto.getUrl();
        this.contentsTitle = contentsDto.getTitle();
        this.contentsUrl = contentsDto.getImgUrl();
    }
}
