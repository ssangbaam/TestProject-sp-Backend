package demo.dtc.domain.psb.comment;

import demo.dtc.domain.psb.Post;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 255, name = "content")
    private String content;
    @Temporal(TemporalType.DATE)
    private Date commentdate;
    @ManyToOne
    private Post post;

    protected Comment() {}

    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
        this.commentdate = new Date();
    }

    public String getContent() {
        return content;
    }
}
