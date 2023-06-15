package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.Role;

import java.util.List;

public interface RolePersistence {
    Object create(Role role);
    List<Role> getRoles();
    Role getRoleById(long id);
    Object update(Role role);
}
