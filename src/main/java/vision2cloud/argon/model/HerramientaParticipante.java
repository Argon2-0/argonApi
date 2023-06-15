package vision2cloud.argon.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "herramienta_participantes")
public class HerramientaParticipante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    private Participante participante;
    @ManyToOne
    private Herramienta herramienta;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "totHoras")
    private Long totHoras;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public HerramientaParticipante() {
    }

    public HerramientaParticipante(long id, Participante participante, Herramienta herramienta, String observacion, String estado, Long tot_horas, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.participante = participante;
        this.herramienta = herramienta;
        this.observacion = observacion;
        this.estado = estado;
        this.totHoras = tot_horas;
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

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTot_horas() {
        return totHoras;
    }

    public void setTot_horas(Long totHoras) {
        this.totHoras = totHoras;
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
        return "HerramientaParticipantes{" +
                "id=" + id +
                ", participante=" + participante +
                ", herramienta=" + herramienta +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", totHoras=" + totHoras +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
