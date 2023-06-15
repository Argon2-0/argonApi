package vision2cloud.argon.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserLogin;
import vision2cloud.argon.persistence.Impl.user.UserImpl;
import vision2cloud.argon.persistence.Impl.user.UserLoginImpl;

import java.util.List;

@Service("UserLoginService")
public class UserLoginService {
    @Autowired
    @Qualifier("UserLoginImpl")
    UserLoginImpl userLoginImpl;

    public UserLogin Login(String email, String password){return userLoginImpl.Login(email, password);}

    public Object update(UserLogin user) {
        return userLoginImpl.update(user);
    }
}
