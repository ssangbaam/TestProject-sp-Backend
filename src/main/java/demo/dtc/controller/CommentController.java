package demo.dtc.controller;

import demo.dtc.dto.request.CommentCreateRequest;
import demo.dtc.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}/comment")
    public void saveComment(@RequestBody CommentCreateRequest commentCreateRequest, @PathVariable Long postId) {
        commentService.saveComment(commentCreateRequest, postId);
    }
}
