package gwangjang.server.domain.community.domain.repository;

import gwangjang.server.domain.community.domain.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long>, CommunityCustomRepository {


}
