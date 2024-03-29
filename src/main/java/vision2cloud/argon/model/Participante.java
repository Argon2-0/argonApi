package vision2cloud.argon.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Timestamp;

@Entity
@Table(name = "participantes")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Column(name = "cedula")
    private Long cedula;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "tratDatos")
    private String tratDatos;
    @Column(name = "estado")
    private String estado;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public Participante() {
    }

    public Participante(Long id, String tipoDocumento, Long cedula, String nombres, String apellidos, String celular,String email, String tratDatos, String estado, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.tratDatos = tratDatos;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTratDatos() {
        return tratDatos;
    }

    public void setTratDatos(String tratDatos) {
        this.tratDatos = tratDatos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", cedula=" + cedula +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                ", estado='" + estado + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
