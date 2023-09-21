package vision2cloud.argon.persistence.Impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.UserLogin;
import vision2cloud.argon.persistence.user.UserLoginPersistence;
import vision2cloud.argon.repository.user.UserLoginRepository;

import java.util.List;

@Service("UserLoginImpl")
public class UserLoginImpl implements UserLoginPersistence {

    @Autowired
    @Qualifier("UserLoginRepository")
    UserLoginRepository userLoginRepository;

    @Override
    public UserLogin Login(String email) {
        return userLoginRepository.findByEmail(email);
    }

    @Override
    public Object update(UserLogin user) {
        UserLogin actualUser = userLoginRepository.findById(user.getId()).get();
        actualUser.setPassword(user.getPassword());
        return userLoginRepository.save(actualUser);
    }

}
