package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "visita_visitante")
public class VisitaVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "visitanteId")
    private Long visitanteId;
    @ManyToOne
    private Curso Curso;
    @ManyToOne
    private TipoServicio tiposervicio;
    @ManyToOne
    private Empresa empresa;
    @Column(name = "diaInicio")
    private Timestamp diaInicio;
    @Column(name = "diaFin")
    private Timestamp diaFin;

    public VisitaVisitante() {
    }

    public VisitaVisitante(Long visitanteId, Curso Curso, TipoServicio tiposervicio, Timestamp diaInicio, Timestamp diaFin) {
        this.visitanteId = visitanteId;
        this.Curso= Curso;
        this.tiposervicio = tiposervicio;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
    }
    public VisitaVisitante(Long visitanteId, Curso curso, TipoServicio tiposervicio, Empresa empresa, Timestamp diaInicio, Timestamp diaFin) {
        this.visitanteId = visitanteId;
        this.Curso= Curso;
        this.tiposervicio = tiposervicio;
        this.empresa = empresa;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
    }

    public VisitaVisitante(long id, Long visitanteId, Curso curso, TipoServicio tiposervicio, Empresa empresa, Timestamp diaInicio, Timestamp diaFin) {
        this.id = id;
        this.visitanteId = visitanteId;
        this.Curso = Curso;
        this.tiposervicio = tiposervicio;
        this.empresa = empresa;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVisitanteId() {
        return visitanteId;
    }

    public void setVisitanteId(Long visitanteId) {
        this.visitanteId = visitanteId;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public Timestamp getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(Timestamp diaInicio) {
        this.diaInicio = diaInicio;
    }

    public Timestamp getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(Timestamp diaFin) {
        this.diaFin = diaFin;
    }

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "VisitaVisitante{" +
                "id=" + id +
                ", visitanteId=" + visitanteId +
                ", cursoCodigo='" + Curso + '\'' +
                ", tiposervicio=" + tiposervicio +
                ", empresa=" + empresa +
                ", diaInicio=" + diaInicio +
                ", diaFin=" + diaFin +
                '}';
    }
}
