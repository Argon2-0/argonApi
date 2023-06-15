package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "history_tipo_servicios")
public class HistoryTipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private Participante participante;
    @ManyToOne
    private TipoServicio tiposervicio;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public HistoryTipoServicio() {
    }

    public HistoryTipoServicio(long id, Participante participante, TipoServicio tiposervicio, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.participante = participante;
        this.tiposervicio = tiposervicio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
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
        return "HistoryTipoServicios{" +
                "id=" + id +
                ", participante_id=" + participante +
                ", tiposervicio_id=" + tiposervicio +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
