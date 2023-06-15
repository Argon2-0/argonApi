package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Tag;

@Repository("TagRepository")
public interface TagRepository extends JpaRepository<Tag,Integer> {
}
