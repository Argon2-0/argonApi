package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Migration;
import vision2cloud.argon.persistence.Impl.MigrationImpl;

import java.util.List;

@Service("MigrationService")
public class MigrationService {
    @Autowired
    @Qualifier("MigrationImpl")
    MigrationImpl migrationImpl;

    public Object create(Migration migration) {
        return migrationImpl.create(migration);
    }

    public List<Migration> getMigrations() {
        return migrationImpl.getMigrations();
    }

    public Migration getMigrationById(int id) {
        return migrationImpl.getMigrationById(id);
    }

    public Object update(Migration migration) {
        return migrationImpl.update(migration);
    }
}
