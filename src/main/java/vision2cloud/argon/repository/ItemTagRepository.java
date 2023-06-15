package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.ItemTag;

@Repository("ItemTagRepository")
public interface ItemTagRepository extends JpaRepository<ItemTag,Integer> {
}
