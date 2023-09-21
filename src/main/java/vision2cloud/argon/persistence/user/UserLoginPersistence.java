package vision2cloud.argon.persistence.user;

import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserLogin;

import java.util.List;

public interface UserLoginPersistence {
    UserLogin Login(String email);

    Object update(UserLogin user);
}
