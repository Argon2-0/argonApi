package vision2cloud.argon.persistence.Impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.persistence.user.UserPersistence;
import vision2cloud.argon.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("UserImpl")
public class UserImpl implements UserPersistence {

    @Autowired
    @Qualifier("UserRepository")
    UserRepository userRepository;

    @Override
    public Object create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Object update(User user) {
        User actualUser = getUserById(user.getId());
        actualUser.setName(user.getName());
        actualUser.setEmail(user.getEmail());
        actualUser.setemailVerifiedAt(user.getemailVerifiedAt());
        actualUser.setPassword(user.getPassword());
        actualUser.setPicture(user.getPicture());
        actualUser.setRole(user.getRole());
        actualUser.setrememberToken(user.getrememberToken());
        actualUser.setupdatedAt(user.getupdatedAt());
        return userRepository.save(actualUser);
    }

    @Override
    public Object createMasive(ArrayList<User> users) {
        return userRepository.saveAll(users);
    }
}
