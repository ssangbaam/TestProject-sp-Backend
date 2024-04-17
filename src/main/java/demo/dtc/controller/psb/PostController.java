package demo.dtc.controller.psb;

import demo.dtc.domain.psb.Post;
import demo.dtc.domain.psb.comment.Comment;
import demo.dtc.dto.psb.request.CommentRequest;
import demo.dtc.dto.psb.request.PostPostRequest;
import demo.dtc.dto.psb.response.PostResponse;
import demo.dtc.service.psb.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public void savePost(@RequestBody PostPostRequest request){
        postService.savePost(request);
    }

    @GetMapping("/post")
    public List<PostResponse> getPost() {
        return postService.getPost();
    }

    @GetMapping("/{postId}")
    public Post getDetailPost(@PathVariable Long postId) {
        return postService.getDetailPost(postId);
    }

    @PostMapping("/{postId}/comment")
    public void addComment(@PathVariable Long postId, @RequestBody CommentRequest commentRequest) {
        postService.addComment(postId, commentRequest);
    }

    @GetMapping("/{postId}/comment")
    public List<Comment> getComments(@PathVariable Long postId) {
        return postService.getComments(postId);
    }
}
