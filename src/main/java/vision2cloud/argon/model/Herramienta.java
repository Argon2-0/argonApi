package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "marca")
    private String marca;
    @Column(name = "serial")
    private String serial;
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Column(name = "estado")
    private String estado;
    @ManyToOne
    private Participante participante;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public Herramienta() {
    }

    public Herramienta(Long id, String nombre, String descripcion, String marca, String serial, String codigoBarras, String estado, Participante participante, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.serial = serial;
        this.codigoBarras = codigoBarras;
        this.estado = estado;
        this.participante = participante;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getcodigoBarras() {
        return codigoBarras;
    }

    public void setcodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Timestamp getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Herramientas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                ", serial='" + serial + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", estado='" + estado + '\'' +
                ", participante_id=" + participante +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
