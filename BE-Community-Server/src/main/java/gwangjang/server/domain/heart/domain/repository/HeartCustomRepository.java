package gwangjang.server.domain.heart.domain.repository;

import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.domain.entity.Heart;

import java.util.List;
import java.util.Optional;

public interface HeartCustomRepository {

    Optional<HeartRes> findHeartByPusherIdAndCommunityId(String pusherId, Long communityId);

    Optional<List<HeartRes>> findAllHeartByPusherIdAndCommunityId(String pusherId, Long communityId);

    Optional<Heart> findHeartById(String pusherId, Long communityId);

}