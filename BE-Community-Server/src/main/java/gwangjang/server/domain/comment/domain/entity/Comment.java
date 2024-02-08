package gwangjang.server.domain.comment.domain.entity;

import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String talk;
    private String writerId;

    @ManyToOne
    @JoinColumn(name="community_id")
    private Community community;

}
