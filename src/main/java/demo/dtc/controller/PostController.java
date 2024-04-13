package demo.dtc.controller;

import demo.dtc.dto.request.PostCreateRequest;
import demo.dtc.dto.response.CommentResponse;
import demo.dtc.dto.response.PostDetailResponse;
import demo.dtc.dto.response.PostResponse;
import demo.dtc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public void savePost(@RequestBody PostCreateRequest postCreateRequest) {
        postService.savePost(postCreateRequest);
    }

    @GetMapping("/post")
    public List<PostResponse> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    public PostDetailResponse getPostDetail(@PathVariable Long postId) {
        return postService.getPostDetail(postId);
    }

    @GetMapping("/{postId}/comment")
    public List<CommentResponse> getCommentsInPost(@PathVariable Long postId) {
        return postService.getCommentsInPost(postId);
    }
}
