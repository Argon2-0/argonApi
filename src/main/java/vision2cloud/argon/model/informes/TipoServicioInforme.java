package vision2cloud.argon.model.informes;

public class TipoServicioInforme {

    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String nombres;
    private String apellidos;
    private String celular;
    private String email;
    private String nombreTipoServicio;
    private String descripcionTipoServicio;
    private String fechaHora;
    private String tratDatos;



    public TipoServicioInforme() {
    }


    public TipoServicioInforme(String tipoDocumentovisitante, Long documentovisitante, String nombres, String apellidos, String celular, String email, String nombreTipoServicio, String descripcionTipoServicio, String fechaHora, String tratDatos) {
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcionTipoServicio = descripcionTipoServicio;
        this.fechaHora = fechaHora;
        this.tratDatos = tratDatos;
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

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public String getDescripcionTipoServicio() {
        return descripcionTipoServicio;
    }

    public void setDescripcionTipoServicio(String descripcionTipoServicio) {
        this.descripcionTipoServicio = descripcionTipoServicio;
    }
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTratDatos() {
        return tratDatos;
    }

    public void setTratDatos(String tratDatos) {
        this.tratDatos = tratDatos;
    }

    @Override
    public String toString() {
        return "TipoServicioInforme{" +
                "TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", nombreTipoServicio='" + nombreTipoServicio + '\'' +
                ", descripcionTipoServicio='" + descripcionTipoServicio + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                '}';
    }
}


