package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.model.Item;

import java.util.ArrayList;
import java.util.List;

public interface EmpresaPersistence {
    Object create(Empresa item);
    List<Empresa> getEmpresas();
    List<Empresa> getEmpresasByDisponible(String disponible);
    Empresa getEmpresaByNit(String nit);

    Object update(Empresa item);

    Object createMasive(ArrayList<Empresa> empresas);
}
