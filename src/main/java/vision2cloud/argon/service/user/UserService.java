package vision2cloud.argon.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.user.User;
import vision2cloud.argon.persistence.Impl.user.UserImpl;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserService {
    @Autowired
    @Qualifier("UserImpl")
    UserImpl userImpl;

    public Object create(User user) {
        return userImpl.create(user);
    }

    public List<User> getUsers() {
        return userImpl.getUsers();
    }

    public User getUserById(int id) {
        return userImpl.getUserById(id);
    }

    public Object update(User user) {
        return userImpl.update(user);
    }

    public Object createMasive(ArrayList<User> users) {return userImpl.createMasive(users);
    }
}
