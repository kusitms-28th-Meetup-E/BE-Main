package gwangjang.server.domain.heart.application.service;


import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.service.CommunityQueryService;
import gwangjang.server.domain.heart.application.dto.res.HeartRes;
import gwangjang.server.domain.heart.application.mapper.HeartMapper;
import gwangjang.server.domain.heart.domain.entity.Heart;
import gwangjang.server.domain.heart.domain.service.HeartQueryService;
import gwangjang.server.domain.heart.domain.service.HeartSaveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HeartUpdateUseCase {


    private final HeartSaveService heartSaveService;
    private final HeartQueryService heartQueryService;

    private final CommunityQueryService communityQueryService;

    private final HeartMapper heartMapper = new HeartMapper();

    public HeartRes pushHeart(String pusherId, Long communityId) {

        Optional<Heart> heart = heartQueryService.getHeartById(pusherId, communityId);
        if (heart.isPresent()) {
            // update
            Heart updateHeart = heart.get();
            updateHeart.updateHeart();
            return heartMapper.mapToHeartRes(updateHeart);

        } else{
            // new
            Community community = communityQueryService.getCommunityById(communityId);
            Heart save = heartSaveService.save(heartMapper.mapToHeart(pusherId, community));
            community.updateHearts(save);
            return heartMapper.mapToHeartRes(save);
        }

    }
}
