package gwangjang.server.domain.comment.domain.repository;

import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository {

}
