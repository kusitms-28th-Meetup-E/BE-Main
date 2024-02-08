package gwangjang.server.domain.community.domain.repository;

import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;

import java.util.List;
import java.util.Optional;

public interface CommunityCustomRepository {


    Optional<List<CommunityRes>> findAllCommunityByTopic(String memberId, String topic);
    Optional<List<CommunityRes>> findAllCommunity(String memberId);
    Optional<CommunityRes> findCommunity(String memberId,Long communityId);
    Optional<List<CommunityRes>> findCommunityTop5ByHeartsAndTopic(String memberId,String topic);

    Optional<List<CommunityRes>> findCommunityTop5(String memberId,CommunityOrderCondition orderCondition, String word);
    Optional<List<CommunityRes>> getSearchCommunity(String memberId,CommunityOrderCondition orderCondition, String keyword);

    Optional<List<CommunityRes>> findCommunityByMyHearts(String memberId);
    Optional<List<CommunityRes>> findCommunityByMyId(String memberId);
}
