package demo.dtc.dto.psb.response;

import demo.dtc.domain.psb.Post;

public class PostResponse {
    private Long id;
    private String title;

    public PostResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
    }
}
