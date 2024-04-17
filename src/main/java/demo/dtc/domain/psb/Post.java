package demo.dtc.domain.psb;

import demo.dtc.domain.psb.comment.Comment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = true, length = 429496729)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    Date postdate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    protected Post() {}

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.postdate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(String content) {
        comments.add(new Comment(this, content));
    }
}
