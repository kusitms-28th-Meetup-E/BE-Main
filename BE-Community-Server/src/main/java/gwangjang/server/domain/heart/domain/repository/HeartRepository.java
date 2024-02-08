package gwangjang.server.domain.heart.domain.repository;

import gwangjang.server.domain.heart.domain.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long>, HeartCustomRepository {


}
