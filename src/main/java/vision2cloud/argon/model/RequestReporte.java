package vision2cloud.argon.model;

import java.sql.Timestamp;

public class RequestReporte {
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private String marcaEquipo;
    private Long cedula;

    public RequestReporte() {
    }

    public RequestReporte(Timestamp fechaInicio, Timestamp fechaFin, String marcaEquipo, Long cedula) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.marcaEquipo = marcaEquipo;
        this.cedula = cedula;
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

    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "RequestReporte{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", marcaEquipo='" + marcaEquipo + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
