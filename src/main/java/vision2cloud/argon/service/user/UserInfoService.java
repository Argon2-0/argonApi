package vision2cloud.argon.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserInfo;
import vision2cloud.argon.persistence.Impl.user.UserImpl;
import vision2cloud.argon.persistence.Impl.user.UserInfoImpl;

import java.util.List;

@Service("UserInfoService")
public class UserInfoService {
    @Autowired
    @Qualifier("UserInfoImpl")
    UserInfoImpl userInfoImpl;

    public List<UserInfo> getUsers() {
        return userInfoImpl.getUsers();
    }

    public UserInfo getUserById(int id) {
        return userInfoImpl.getUserById(id);
    }

    public Object update(UserInfo user) {
        return userInfoImpl.update(user);
    }

    public UserInfo getByEmail(String email) {
        return userInfoImpl.getByEmail(email);
    }
}
