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
    @Column(name = "fechaNacimiento")
    private Timestamp fechaNacimiento;
    @Column(name = "celular")
    private String celular;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @ManyToOne
    private TipoServicio tiposervicio;
    @Column(name = "curso")
    private String curso;
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

    public Participante(Long id, String tipoDocumento, Long cedula, String nombres, String apellidos, Timestamp fechaNacimiento, String celular, String sexo, String email, TipoServicio tiposervicio, String curso, String tratDatos, String estado, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.sexo = sexo;
        this.email = email;
        this.tiposervicio = tiposervicio;
        this.curso = curso;
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

    public String gettipoDocumento() {
        return tipoDocumento;
    }

    public void settipoDocumento(String tipoDocumento) {
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

    public Timestamp getfechaNacimiento() {
        return fechaNacimiento;
    }

    public void setfechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String gettratDatos() {
        return tratDatos;
    }

    public void settratDatos(String tratDatos) {
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
        return "Participante{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", cedula=" + cedula +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", celular='" + celular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                ", tiposervicio_id=" + tiposervicio +
                ", curso='" + curso + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                ", estado='" + estado + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
