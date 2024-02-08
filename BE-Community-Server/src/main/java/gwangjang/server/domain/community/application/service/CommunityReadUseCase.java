package gwangjang.server.domain.community.application.service;


import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.dto.res.SearchRes;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import gwangjang.server.domain.community.domain.service.CommunityQueryService;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class CommunityReadUseCase {

    private final CommunityQueryService communityQueryService;


    public List<CommunityRes> getCommunityList(String memberId,String topic) {

        return communityQueryService.getAllCommunityByTopic(memberId,topic);
    }
    public List<CommunityRes> getAllCommunityList(String memberId) {

        return communityQueryService.getAllCommunity(memberId);
    }
    public CommunityRes getCommunityDetail(String memberId,Long topicId,Long communityId) {

        return communityQueryService.getCommunity(memberId,communityId);
    }

    public List<CommunityRes> getCommunityTop5ByHearts(String memberId,String orderBy, String word) {

        return communityQueryService.getCommunityTop5(memberId,CommunityOrderCondition.valueOf(orderBy), word);
    }

    public List<CommunityRes> getCommunityByMyHearts(String memberId) {

        return communityQueryService.getCommunityByMyHearts(memberId);
    }

    public List<CommunityRes> getCommunityByMyId(String memberId) {
        return communityQueryService.getCommunityByMyId(memberId);
    }

    public SearchRes getSearchList(String memberId,String orderBy,String keyword){
        return communityQueryService.search(memberId,CommunityOrderCondition.valueOf(orderBy),keyword);

    }
}
