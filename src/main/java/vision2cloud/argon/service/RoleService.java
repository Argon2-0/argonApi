package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Role;
import vision2cloud.argon.persistence.Impl.RoleImpl;

import java.util.List;

@Service("RoleService")
public class RoleService {
    @Autowired
    @Qualifier("RoleImpl")
    RoleImpl roleImpl;

    public Object create(Role role) {
        return roleImpl.create(role);
    }

    public List<Role> getRoles() {
        return roleImpl.getRoles();
    }

    public Role getRoleById(long id) {
        return roleImpl.getRoleById(id);
    }

    public Object update(Role role) {
        return roleImpl.update(role);
    }
}
