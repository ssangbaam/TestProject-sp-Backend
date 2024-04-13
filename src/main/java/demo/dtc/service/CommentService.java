package demo.dtc.service;

import demo.dtc.domain.Comment;
import demo.dtc.domain.Post;
import demo.dtc.dto.request.CommentCreateRequest;
import demo.dtc.repository.CommentRepository;
import demo.dtc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void saveComment(CommentCreateRequest commentCreateRequest, Long postId) {
        Post post =  postRepository.findById(postId).orElseThrow(IllegalAccessError::new);

        commentRepository.save(new Comment(commentCreateRequest.getContent(), post));
    }
}
