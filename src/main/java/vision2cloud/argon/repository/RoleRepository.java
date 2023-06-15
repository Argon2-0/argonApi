package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Role;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
