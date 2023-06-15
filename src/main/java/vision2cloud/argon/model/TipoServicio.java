package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tipo_servicios")
public class TipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
    @Column(name = "form")
    private String form;

    public TipoServicio() {
    }

    public TipoServicio(long id, String nombre, String descripcion, Timestamp createdAt, Timestamp updatedAt, String form) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.form = form;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "TipoServicio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", form='" + form + '\'' +
                '}';
    }
}
