package gwangjang.server.domain.comment.application.mapper;

import gwangjang.server.domain.comment.application.dto.req.CommentReq;
import gwangjang.server.domain.comment.application.dto.res.CommentRes;
import gwangjang.server.domain.comment.domain.entity.Comment;
import gwangjang.server.domain.community.application.dto.res.MemberDto;
import gwangjang.server.domain.community.domain.entity.Community;
import gwangjang.server.global.annotation.Mapper;

@Mapper
public class CommentMapper {


    public Comment mapToComment(String memberId, Community community, CommentReq commentReq) {
        return Comment.builder()
                .writerId(memberId)
                .talk(commentReq.getTalk())
                .community(community)
                .build();
    }

    public CommentRes mapToCommentRes(MemberDto memberDto, Comment comment) {
        return CommentRes.builder()
                .talk(comment.getTalk())
                .createAt(comment.getCreatedAt().toString())
                .writerId(memberDto.getMemberId())
                .nickname(memberDto.getNickname())
                .profileImg(memberDto.getProfileImage())
                .build();
    }

}
