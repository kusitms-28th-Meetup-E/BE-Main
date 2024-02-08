package gwangjang.server.domain.heart.domain.entity;

import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Heart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    private String pusherId;


    private boolean status;


    public void updateHeart() {
        if (this.status) {
            this.status = Boolean.FALSE;
        } else{
            this.status = Boolean.TRUE;
        }
    }
}
