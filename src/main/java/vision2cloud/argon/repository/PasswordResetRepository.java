package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.PasswordReset;

@Repository("PasswordResetRepository")
public interface PasswordResetRepository extends JpaRepository<PasswordReset,Integer> {
}
