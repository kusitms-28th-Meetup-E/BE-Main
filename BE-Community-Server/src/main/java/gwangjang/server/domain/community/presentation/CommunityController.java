package gwangjang.server.domain.community.presentation;

import gwangjang.server.domain.community.application.dto.req.CommunityReq;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.application.dto.res.SearchRes;
import gwangjang.server.domain.community.application.service.CommunityCreateUseCase;
import gwangjang.server.domain.community.application.service.CommunityReadUseCase;
import gwangjang.server.domain.community.domain.entity.constant.CommunityOrderCondition;
import gwangjang.server.domain.community.presentation.constant.CommunityResponseMessage;
import gwangjang.server.global.response.SuccessResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommunityController {

    private final CommunityCreateUseCase communityCreateUseCase;
    private final CommunityReadUseCase communityReadUseCase;


    /**
     * 커뮤니티 글 작성 (인용글 연결된 버튼 통해서만)
     * @param socialId 유저 정보
     * @param contentsId 인용글 정보
     * @param communityReq 커뮤니티 글 내용
     * @return
     */
    @PostMapping("/contents/{contentsId}")
    public ResponseEntity<SuccessResponse<CommunityRes>> createCommunity(@RequestHeader(value = "user-id") String socialId, @PathVariable("contentsId") Long contentsId, @RequestBody CommunityReq communityReq) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.CREATE_COMMUNITY_SUCCESS.getMessage(), this.communityCreateUseCase.create(socialId, contentsId, communityReq)));
    }


    /**
     * 커뮤니티 글 리스트업(전체)
     *ㄷㄱㄷ
     * @return
     */
    @GetMapping("")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityList(@RequestHeader(value = "user-id") String socialId ) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getAllCommunityList(socialId)));
    }


    /**
     * 커뮤니티 글 리스트업(영역별)
     * @param topic 영역 정보
     * @return
     */
    @GetMapping("/topic/{topic}")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityListByDomain(@RequestHeader(value = "user-id") String socialId,@PathVariable("topic") String topic) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityList(socialId,topic)));
    }

    /**
     * 커뮤니티 글 리스트텁(상세)
     * @param topicId 영역 정보
     * @return
     */
    @GetMapping("/topic/{topicId}/community/{communityId}")
    public ResponseEntity<SuccessResponse<CommunityRes>> getCommunityDetail(@RequestHeader(value = "user-id") String socialId, @PathVariable("topicId") Long topicId, @PathVariable("communityId") Long communityId) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityDetail(socialId,topicId,communityId)));
    }

    /**
     * 커뮤니티 글 top5(영역/주제/키워드)
     * @param sortBy 정렬 조건
     * @param word 정렬 단어
     * @return
     */
    @GetMapping("/sortBy/{sortBy}/word/{word}")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getCommunityTop5(@RequestHeader(value = "user-id") String socialId, @PathVariable("sortBy") String sortBy,@PathVariable("word") String word ) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityTop5ByHearts(socialId,sortBy,word)));
    }

    @GetMapping("/mypage")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getMyHeartCommunity(@RequestHeader(value = "user-id") String socialId) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityByMyHearts(socialId)));
    }

    @GetMapping("/mywrite")
    public ResponseEntity<SuccessResponse<List<CommunityRes>>> getMyCommunity(@RequestHeader(value = "user-id") String socialId) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(), this.communityReadUseCase.getCommunityByMyId(socialId)));
    }


    @GetMapping("/search/{word}")
    public ResponseEntity<SuccessResponse<SearchRes>> search(@RequestHeader(value = "user-id") String socialId, @PathVariable("word") String word) {
        return ResponseEntity.ok(SuccessResponse.create(CommunityResponseMessage.GET_COMMUNITY_SUCCESS.getMessage(),this.communityReadUseCase.getSearchList(socialId ,"SEARCH",word)));
    }



}


