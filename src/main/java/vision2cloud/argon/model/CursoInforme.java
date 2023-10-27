package vision2cloud.argon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class CursoInforme {

    private String codigo;
    private String nombre;
    private String visitante;

    public CursoInforme() {
    }

    public CursoInforme(String codigo, String nombre, String visitante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitante = visitante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "CursoInforme{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", visitante='" + visitante + '\'' +
                '}';
    }
}
