package vision2cloud.argon.persistence.Impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.model.user.UserInfo;
import vision2cloud.argon.persistence.user.UserInfoPersistence;
import vision2cloud.argon.persistence.user.UserPersistence;
import vision2cloud.argon.repository.user.UserInfoRepository;
import vision2cloud.argon.repository.user.UserRepository;

import java.util.List;

@Service("UserInfoImpl")
public class UserInfoImpl implements UserInfoPersistence {

    @Autowired
    @Qualifier("UserInfoRepository")
    UserInfoRepository userInfoRepository;

    @Override
    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo getUserById(int id) {
        return userInfoRepository.findById(id).get();
    }

    @Override
    public Object update(UserInfo user) {
        UserInfo actualUser = getUserById(user.getId());
        actualUser.setName(user.getName());
        actualUser.setEmail(user.getEmail());
        actualUser.setemailVerifiedAt(user.getemailVerifiedAt());
        actualUser.setPicture(user.getPicture());
        actualUser.setRole(user.getRole());
        actualUser.setrememberToken(user.getrememberToken());
        actualUser.setupdatedAt(user.getupdatedAt());
        return userInfoRepository.save(actualUser);
    }

    @Override
    public UserInfo getByEmail(String email) {
        return userInfoRepository.findByEmail(email);
    }
}
