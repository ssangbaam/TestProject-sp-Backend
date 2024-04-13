package demo.dtc.dto.response;

import demo.dtc.domain.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PostDetailResponse {
    private final String title;
    private final String content;
    private final List<CommentResponse> comments;

    public PostDetailResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getComments().stream()
                .map(comment -> new CommentResponse(comment.getContent()))
                .toList();
    }
}
