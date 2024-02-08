package gwangjang.server.domain.community.application.mapper;

import gwangjang.server.domain.community.application.dto.res.ContentsDto;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.application.dto.req.CommunityReq;
import gwangjang.server.domain.community.application.dto.res.CommunityRes;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class CommunityMapper {

    public Community mapToCommunity(String memberId, ContentsDto contentsDto, CommunityReq communityReq){
        return Community.builder()
                .talk(communityReq.getCommunityText())
                .contentsId(contentsDto.getContents_id())
                .writerId(memberId)
                .keyword(contentsDto.getKeyword())
                .issue(contentsDto.getIssueTitle())
                .topic(contentsDto.getTopic())
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community, MemberDto memberDto, ContentsDto contentsDto) {
        return CommunityRes.builder()
                .id(community.getId())
                .communityText(community.getTalk())
                .date(community.getCreatedAt().toString())
                .writerId(memberDto.getMemberId())
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .contents(contentsDto.getUrl())
                .keyword(contentsDto.getKeyword())
                .subject(contentsDto.getIssueTitle())
                .area(contentsDto.getTopic())
                .build();
    }

    public CommunityRes mapToCommunityResByMemberDto(MemberDto memberDto) {
        return CommunityRes.builder()
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .build();
    }

    public CommunityRes mapToCommunityRes(Community community) {
        return CommunityRes.builder()
                .id(community.getId())
                .communityText(community.getTalk())
                .date(community.getCreatedAt().toString()) // 날짜 형식에 따라 수정
                .writerId(community.getWriterId())
                .area(community.getTopic())
                .subject(community.getIssue())
                .keyword(community.getKeyword())
                .likeCount((long) community.getHearts().size()) // 가정: 좋아요는 hearts 리스트에 저장되어 있다고 가정
                .commentCount((long) community.getComments().size()) // 가정: 댓글은 comments 리스트에 저장되어 있다고 가정
                .contentsId(community.getContentsId())
                .likeStatus(null) // 사용자의 좋아요 상태에 따라 설정
                .build();
    }

}
