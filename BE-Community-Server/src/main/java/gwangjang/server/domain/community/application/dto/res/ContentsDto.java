package gwangjang.server.domain.community.application.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDto {

//    private Long contents_Id;
//    private String contents;
//
//    private String keyword;
//    private String issue;
//    private String topic;

    private Long contents_id;
    private String url;
    private String title;
    private String description;
    private String type;
    private String issueTitle;
    private String keyword;
    private String pubDate;
    private String topic;
    private String imgUrl;

    private Long likeCount;

    private String heartStatus;


}
