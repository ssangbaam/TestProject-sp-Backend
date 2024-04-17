package demo.dtc.repository.psb;

import demo.dtc.domain.psb.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
