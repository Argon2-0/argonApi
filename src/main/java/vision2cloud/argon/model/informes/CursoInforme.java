package vision2cloud.argon.model.informes;

public class CursoInforme {

    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String nombres;
    private String apellidos;
    private String celular;
    private String email;
    private String codigo;
    private String nombreEvento;
    private String fechaHora;
    private String tratDatos;



    public CursoInforme() {
    }


    public CursoInforme(String tipoDocumentovisitante, Long documentovisitante, String nombres, String apellidos, String celular, String email, String codigo, String nombreEvento, String fechaHora, String tratDatos) {
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.codigo = codigo;
        this.nombreEvento = nombreEvento;
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
        return "CursoInforme{" +
                "TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", fechaHora='" + fechaHora + '\'' +
                ", tratDatos='" + tratDatos + '\'' +
                '}';
    }
}


