package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Item;

@Repository("ItemRepository")
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
