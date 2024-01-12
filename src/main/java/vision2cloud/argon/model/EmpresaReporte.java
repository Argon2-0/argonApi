package vision2cloud.argon.model;

public class EmpresaReporte {

    private String nit;
    private String nombre;
    private int numeroAsociados;
    public EmpresaReporte(String nit, String nombre, int numeroAsociados) {
        this.nit = nit;
        this.nombre = nombre;
        this.numeroAsociados = numeroAsociados;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDisponible() {
        return numeroAsociados;
    }

    public void setDisponible(int numeroAsociados) {
        this.numeroAsociados = numeroAsociados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nit=" + nit +
                ", nombre='" + nombre + '\'' +
                ", numeroAsociados='" + numeroAsociados + '\'' +
                '}';
    }
}
