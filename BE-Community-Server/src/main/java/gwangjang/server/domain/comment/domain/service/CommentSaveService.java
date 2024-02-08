package gwangjang.server.domain.comment.domain.service;

import gwangjang.server.domain.comment.domain.entity.Comment;
import gwangjang.server.domain.comment.domain.repository.CommentRepository;
import gwangjang.server.global.annotation.DomainService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class CommentSaveService {

    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
