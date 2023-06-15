package vision2cloud.argon.persistence.user;

import vision2cloud.argon.model.user.User;

import java.util.ArrayList;
import java.util.List;

public interface UserPersistence {
    Object create(User user);
    List<User> getUsers();
    User getUserById(int id);
    Object update(User user);

    Object createMasive(ArrayList<User> users);
}
