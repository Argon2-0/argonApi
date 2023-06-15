package vision2cloud.argon.model;

import javax.persistence.*;

@Entity
@Table(name = "migrations")
public class Migration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "migration")
    private String migration;
    @Column(name = "batch")
    private int batch;

    public Migration() {
    }

    public Migration(int id, String migration, int batch) {
        this.id = id;
        this.migration = migration;
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMigration() {
        return migration;
    }

    public void setMigration(String migration) {
        this.migration = migration;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Migration{" +
                "id=" + id +
                ", migration='" + migration + '\'' +
                ", batch=" + batch +
                '}';
    }
}
