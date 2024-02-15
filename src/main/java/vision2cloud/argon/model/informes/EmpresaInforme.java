package vision2cloud.argon.model.informes;

public class EmpresaInforme {

    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String nombres;
    private String apellidos;
    private String celular;
    private String email;
    private String nitEmpresa;
    private String nombreEmpresa;
    private String fechaHora;
    private String tratDatos;



    public EmpresaInforme() {
    }


    public EmpresaInforme(String tipoDocumentovisitante, Long documentovisitante, String nombres, String apellidos, String celular, String email, String nitEmpresa, String nombreEmpresa, String fechaHora, String tratDatos) {
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
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
        return "EmpresaInforme{" +
                "TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", nitEmpresa='" + nitEmpresa + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                '}';
    }
}


