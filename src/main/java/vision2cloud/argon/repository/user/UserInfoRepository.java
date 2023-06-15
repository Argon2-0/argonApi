package vision2cloud.argon.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserInfo;

@Repository("UserInfoRepository")
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByEmail(String email);
}
