package demo.dtc.service;

import demo.dtc.domain.Post;
import demo.dtc.dto.request.PostCreateRequest;
import demo.dtc.dto.response.CommentResponse;
import demo.dtc.dto.response.PostDetailResponse;
import demo.dtc.dto.response.PostResponse;
import demo.dtc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void savePost(PostCreateRequest postCreateRequest) {
        postRepository.save(new Post(postCreateRequest.getTitle(), postCreateRequest.getContent()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPosts() {
        List<PostResponse> posts = postRepository.findAll().stream()
                .map(post -> new PostResponse(post.getTitle(), post.getContent()))
                .toList();

        return posts;
    }

    @Transactional(readOnly = true)
    public PostDetailResponse getPostDetail(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);

        return new PostDetailResponse(post);
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> getCommentsInPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);

        List<CommentResponse> comments = post.getComments().stream()
                .map(comment -> new CommentResponse(comment.getContent()))
                .toList();

        return comments;
    }
}
