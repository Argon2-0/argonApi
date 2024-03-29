package vision2cloud.argon.model.informes;

public class ReportesInforme {

    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String nombres;
    private String apellidos;
    private String celular;
    private String email;
    private String nitEmpresa;
    private String nombreEmpresa;
    private String codigo;
    private String nombreEvento;
    private String nombreTipoServicio;
    private String descripcionTipoServicio;
    private String fechaHora;
    private String molinete;
    private String tratDatos;



    public ReportesInforme() {
    }


    public ReportesInforme(String tipoDocumentovisitante, Long documentovisitante, String nombres, String apellidos, String celular, String email, String nitEmpresa, String nombreEmpresa, String codigo, String nombreEvento, String nombreTipoServicio, String descripcionTipoServicio, String fechaHora, String molinete, String tratDatos) {
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.codigo = codigo;
        this.nombreEvento = nombreEvento;
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcionTipoServicio = descripcionTipoServicio;
        this.fechaHora = fechaHora;
        this.molinete = molinete;
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

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
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

    public String getMolinete() {
        return molinete;
    }

    public void setMolinete(String molinete) {
        this.molinete = molinete;
    }

    public String getTratDatos() {
        return tratDatos;
    }

    public void setTratDatos(String tratDatos) {
        this.tratDatos = tratDatos;
    }

    @Override
    public String toString() {
        return "ReportesInforme{" +
                "TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", nitEmpresa='" + nitEmpresa + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", nombreTipoServicio='" + nombreTipoServicio + '\'' +
                ", descripcionTipoServicio='" + descripcionTipoServicio + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                ", molinete='" + molinete + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                '}';
    }
}


