package demo.dtc.dto.psb.request;

public class PostPostRequest {
    private String title;
    private String content;

    public PostPostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
