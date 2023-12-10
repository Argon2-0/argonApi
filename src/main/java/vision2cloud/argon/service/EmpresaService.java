package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.model.Item;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.persistence.Impl.EmpresaImpl;

import java.util.ArrayList;
import java.util.List;

@Service("EmpresaService")
public class EmpresaService {
    @Autowired
    @Qualifier("EmpresaImpl")
    EmpresaImpl empresaImpl;

    public Object create(Empresa item) {
        return empresaImpl.create(item);
    }

    public List<Empresa> getEmpresas() {
        return empresaImpl.getEmpresas();
    }
    public List<Empresa> getEmpresasByDisponible(String disponible) {
        return empresaImpl.getEmpresasByDisponible(disponible);
    }

    public Empresa getEmpresaByNit(int nit) {
        return empresaImpl.getEmpresaByNit(nit);
    }

    public Object update(Empresa item) {
        return empresaImpl.update(item);
    }

    public Object createMasive(ArrayList<Empresa> empresas) {
        return empresaImpl.createMasive(empresas);
    }
}
