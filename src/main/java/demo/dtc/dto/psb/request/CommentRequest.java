package demo.dtc.dto.psb.request;

public class CommentRequest {
    private Long id;
    private Long postId;
    private String content;

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }
}
