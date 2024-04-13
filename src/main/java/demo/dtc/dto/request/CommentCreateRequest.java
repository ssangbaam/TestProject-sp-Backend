package demo.dtc.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CommentCreateRequest {
    private final String content;

    @JsonCreator
    public CommentCreateRequest(String content) {
        this.content = content;
    }
}
