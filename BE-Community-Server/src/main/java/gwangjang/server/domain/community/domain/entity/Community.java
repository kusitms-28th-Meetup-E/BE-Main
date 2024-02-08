package gwangjang.server.domain.community.domain.entity;

import gwangjang.server.domain.comment.domain.entity.Comment;
import gwangjang.server.domain.heart.domain.entity.Heart;
import gwangjang.server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Community extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long id;
    private String talk;

    private String writerId;

    private Long contentsId; //keyword,issue,domain 불러오기 위함
//    private String contents; // 인용하기 위함
//
    private String keyword; //변하지 않음, contentsId로 가져오기
    private String issue; //변하지 않음 , contentsId로 가져오기
    private String topic; //변하지 않음, contentsId로 가져오기

    @OneToMany(fetch = FetchType.LAZY)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    List<Heart> hearts = new ArrayList<>();


    public void updateComments(Comment comment) {
        this.comments.add(comment);
    }

    public void updateHearts(Heart heart) {
        this.hearts.add(heart);
    }

}


