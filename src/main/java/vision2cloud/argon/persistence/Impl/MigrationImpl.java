package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Migration;
import vision2cloud.argon.persistence.MigrationPersistence;
import vision2cloud.argon.repository.MigrationRepository;

import java.util.List;

@Service("MigrationImpl")
public class MigrationImpl implements MigrationPersistence {

    @Autowired
    @Qualifier("MigrationRepository")
    MigrationRepository migrationRepository;

    @Override
    public Object create(Migration migration) {
        return migrationRepository.save(migration);
    }

    @Override
    public List<Migration> getMigrations() {
        return migrationRepository.findAll();
    }

    @Override
    public Migration getMigrationById(int id) {
        return migrationRepository.findById(id).get();
    }

    @Override
    public Object update(Migration migration) {
        Migration actualMigration = getMigrationById(migration.getId());
        actualMigration.setMigration(migration.getMigration());
        actualMigration.setBatch(migration.getBatch());
        return migrationRepository.save(actualMigration);
    }
}
