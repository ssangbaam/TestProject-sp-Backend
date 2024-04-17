package demo.dtc.service.psb;

import demo.dtc.domain.psb.Post;
import demo.dtc.domain.psb.comment.Comment;
import demo.dtc.dto.psb.request.CommentRequest;
import demo.dtc.dto.psb.request.PostPostRequest;
import demo.dtc.dto.psb.response.PostResponse;
import demo.dtc.repository.psb.CommentRepository;

import demo.dtc.repository.psb.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void savePost(PostPostRequest postPostRequest) {
        postRepository.save(new Post(postPostRequest.getTitle(), postPostRequest.getContent()));
    }

    @Transactional
    public List<PostResponse> getPost() {
        try {
            return postRepository.findAll().stream()
                    .map(post -> new PostResponse(post.getId(), post.getTitle()))
                    .collect(Collectors.toList());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public Post getDetailPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void addComment(Long postId, CommentRequest commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);
        post.addComment(commentRequest.getContent());
        //commentRepository.save(new Comment(post, commentRequest.getContent()));
    }

    @Transactional
    public List<Comment> getComments(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        return post.getComments();
    }
}
