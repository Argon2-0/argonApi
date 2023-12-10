package vision2cloud.argon.model;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "nit")
    private int nit;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "disponible")
    private String disponible;
    public Empresa() {
    }

    public Empresa(int nit, String nombre, String disponible) {
        this.nit = nit;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nit=" + nit +
                ", nombre='" + nombre + '\'' +
                ", disponible='" + disponible + '\'' +
                '}';
    }
}
