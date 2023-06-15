package vision2cloud.argon.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.user.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User,Integer> {
}
