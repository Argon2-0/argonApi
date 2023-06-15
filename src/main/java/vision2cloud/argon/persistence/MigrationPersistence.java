package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Item;
import vision2cloud.argon.model.Migration;

import java.util.List;

public interface MigrationPersistence {
    Object create(Migration migration);
    List<Migration> getMigrations();
    Migration getMigrationById(int id);
    Object update(Migration migration);
}
