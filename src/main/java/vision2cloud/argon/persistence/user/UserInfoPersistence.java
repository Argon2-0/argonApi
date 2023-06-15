package vision2cloud.argon.persistence.user;

import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserInfo;

import java.util.List;

public interface UserInfoPersistence {
    List<UserInfo> getUsers();
    UserInfo getUserById(int id);
    Object update(UserInfo user);
    UserInfo getByEmail(String email);
}
