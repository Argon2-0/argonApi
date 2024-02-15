package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Timestamp;

public class RegistroCurso {

    private String codigo;
    private long tiposervicioId;
    private String empresaNit;
    private String tipoDocumento;
    private Long numeroDocumento;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;

    public RegistroCurso() {
    }

    public RegistroCurso(String codigo, long tiposervicioId, String empresaNit, String tipoDocumento, Long numeroDocumento, Timestamp fechaInicio, Timestamp fechaFin) {
        this.codigo = codigo;
        this.tiposervicioId = tiposervicioId;
        this.empresaNit = empresaNit;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public long getTiposervicioId() {
        return tiposervicioId;
    }

    public void setTiposervicioId(long tiposervicioId) {
        this.tiposervicioId = tiposervicioId;
    }

    public String getEmpresaNit() {
        return empresaNit;
    }

    public void setEmpresaNit(String empresaNit) {
        this.empresaNit = empresaNit;
    }

    @Override
    public String toString() {
        return "RegistroCurso{" +
                "codigo='" + codigo + '\'' +
                ", tiposervicioId=" + tiposervicioId +
                ", empresaNit='" + empresaNit + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
