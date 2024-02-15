package vision2cloud.argon.model.informes;

import java.sql.Timestamp;

public class PrestamosInforme {

    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String nombres;
    private String apellidos;
    private String celular;
    private String email;
    private String marca;
    private String referencia;
    private String codigoBarras;
    private String estado;
    private String observacionPrestamo;
    private String observacionDevolucion;
    private Timestamp fechaPrestamo;
    private Timestamp fechaDevolucion;

    public PrestamosInforme() {
    }

    public PrestamosInforme(String tipoDocumentovisitante, Long documentovisitante, String nombres, String apellidos, String celular, String email, String marca, String referencia, String codigoBarras, String estado, String observacionPrestamo, String observacionDevolucion, Timestamp fechaPrestamo, Timestamp fechaDevolucion) {
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.marca = marca;
        this.referencia = referencia;
        this.codigoBarras = codigoBarras;
        this.estado = estado;
        this.observacionPrestamo = observacionPrestamo;
        this.observacionDevolucion = observacionDevolucion;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getTipoDocumentovisitante() {
        return TipoDocumentovisitante;
    }

    public void setTipoDocumentovisitante(String tipoDocumentovisitante) {
        TipoDocumentovisitante = tipoDocumentovisitante;
    }

    public Long getDocumentovisitante() {
        return Documentovisitante;
    }

    public void setDocumentovisitante(Long documentovisitante) {
        Documentovisitante = documentovisitante;
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

    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getObservacionPrestamo() {
        return observacionPrestamo;
    }

    public void setObservacionPrestamo(String observacionPrestamo) {
        this.observacionPrestamo = observacionPrestamo;
    }

    public String getObservacionDevolucion() {
        return observacionDevolucion;
    }

    public void setObservacionDevolucion(String observacionDevolucion) {
        this.observacionDevolucion = observacionDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Timestamp fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "PrestamosInforme{" +
                "TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", marca='" + marca + '\'' +
                ", referencia='" + referencia + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", estado='" + estado + '\'' +
                ", observacionPrestamo='" + observacionPrestamo + '\'' +
                ", observacionDevolucion='" + observacionDevolucion + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}


