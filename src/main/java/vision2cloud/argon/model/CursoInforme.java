package vision2cloud.argon.model;

public class CursoInforme {

    private String codigo;
    private String nombreEvento;
    private String TipoDocumentovisitante;
    private Long Documentovisitante;
    private String Nombrevisitante;

    public CursoInforme() {
    }

    public CursoInforme(String codigo, String nombreEvento, String tipoDocumentovisitante, Long documentovisitante, String nombrevisitante) {
        this.codigo = codigo;
        this.nombreEvento = nombreEvento;
        TipoDocumentovisitante = tipoDocumentovisitante;
        Documentovisitante = documentovisitante;
        Nombrevisitante = nombrevisitante;
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

    public String getNombrevisitante() {
        return Nombrevisitante;
    }

    public void setNombrevisitante(String nombrevisitante) {
        Nombrevisitante = nombrevisitante;
    }

    @Override
    public String toString() {
        return "CursoInforme{" +
                "codigo='" + codigo + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", TipoDocumentovisitante='" + TipoDocumentovisitante + '\'' +
                ", Documentovisitante=" + Documentovisitante +
                ", Nombrevisitante='" + Nombrevisitante + '\'' +
                '}';
    }
}


