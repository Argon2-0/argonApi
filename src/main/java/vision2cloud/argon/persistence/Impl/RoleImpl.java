package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Role;
import vision2cloud.argon.persistence.RolePersistence;
import vision2cloud.argon.repository.RoleRepository;

import java.util.List;

@Service("RoleImpl")
public class RoleImpl implements RolePersistence {

    @Autowired
    @Qualifier("RoleRepository")
    RoleRepository roleRepository;

    @Override
    public Object create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(Role role) {
        Role actualRole = getRoleById(role.getId());
        actualRole.setName(role.getName());
        actualRole.setDescription(role.getDescription());
        actualRole.setupdatedAt(role.getupdatedAt());
        return roleRepository.save(actualRole);
    }
}
