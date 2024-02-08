package gwangjang.server.domain.heart.domain.service;


import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.domain.entity.Heart;
import gwangjang.server.domain.heart.domain.repository.HeartRepository;
import gwangjang.server.domain.heart.exception.NotFoundHeartException;
import gwangjang.server.global.annotation.DomainService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@Transactional
@RequiredArgsConstructor
public class HeartQueryService {

    private final HeartRepository heartRepository;

    public HeartRes getHeartByPusherIdAndCommunityId(String pusherId, Long communityId) {
        return heartRepository.findHeartByPusherIdAndCommunityId(pusherId, communityId).orElseThrow(NotFoundHeartException::new);
    }
    public List<HeartRes> getAllHeartByPusherId(String pusherId, Long communityId) {
        return heartRepository.findAllHeartByPusherIdAndCommunityId(pusherId, communityId).orElseThrow(NotFoundHeartException::new);
    }

    public Optional<Heart> getHeartById(String pusherId, Long communityId) {
        return heartRepository.findHeartById(pusherId, communityId);
    }

}
