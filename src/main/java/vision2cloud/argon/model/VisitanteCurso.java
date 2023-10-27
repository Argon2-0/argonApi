package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "visitante_curso")
public class VisitanteCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "visitanteId")
    private Long visitanteId;
    @Column(name = "cursoCodigo")
    private String cursoCodigo;

    @Column(name = "diaInicio")
    private Timestamp diaInicio;
    @Column(name = "diaFin")
    private Timestamp diaFin;

    public VisitanteCurso() {
    }

    public VisitanteCurso(long id, Long visitanteId, String cursoCodigo, Timestamp diaInicio, Timestamp diaFin) {
        this.id = id;
        this.visitanteId = visitanteId;
        this.cursoCodigo = cursoCodigo;
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

    public String getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(String cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
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

    @Override
    public String toString() {
        return "VisitanteCurso{" +
                "id=" + id +
                ", visitanteId=" + visitanteId +
                ", cursoCodigo='" + cursoCodigo + '\'' +
                ", diaInicio=" + diaInicio +
                ", diaFin=" + diaFin +
                '}';
    }
}
