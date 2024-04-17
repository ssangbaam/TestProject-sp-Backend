package demo.dtc.repository.psb;

import demo.dtc.domain.psb.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
