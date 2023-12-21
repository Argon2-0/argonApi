package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.persistence.EmpresaPersistence;
import vision2cloud.argon.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;

@Service("EmpresaImpl")
public class EmpresaImpl implements EmpresaPersistence {
    @Autowired
    @Qualifier("EmpresaRepository")
    EmpresaRepository empresaRepository;

    @Override
    public Object create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> getEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public List<Empresa> getEmpresasByDisponible(String disponible) {
        return empresaRepository.findByDisponibleLike(disponible);
    }

    @Override
    public Empresa getEmpresaByNit(String nit) {
        List<Empresa> empresas = empresaRepository.findAll();
        for (Empresa empresa: empresas){
            if (empresa.getNit() == nit){
                return empresa;
            }
        }
        return null;
    }

    @Override
    public Object update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Object createMasive(ArrayList<Empresa> empresas) {
        return empresaRepository.saveAll(empresas);
    }
}
