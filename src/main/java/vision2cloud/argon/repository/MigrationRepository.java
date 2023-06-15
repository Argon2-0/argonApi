package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Migration;

@Repository("MigrationRepository")
public interface MigrationRepository extends JpaRepository<Migration,Integer> {
}
