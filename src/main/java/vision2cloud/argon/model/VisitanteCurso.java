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

    public VisitanteCurso() {
    }

    public VisitanteCurso(long id, Long visitanteId, String cursoCodigo) {
        this.id = id;
        this.visitanteId = visitanteId;
        this.cursoCodigo = cursoCodigo;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", visitanteId='" + visitanteId + '\'' +
                ", cursoCodigo='" + cursoCodigo +
                '}';
    }
}
