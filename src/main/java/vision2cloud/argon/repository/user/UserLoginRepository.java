package vision2cloud.argon.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserLogin;

@Repository("UserLoginRepository")
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
    UserLogin findByEmail(String email);
}
