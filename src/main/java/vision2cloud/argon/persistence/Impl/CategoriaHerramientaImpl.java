package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.CategoriaHerramienta;
import vision2cloud.argon.persistence.CategoriaHerramientaPersistence;
import vision2cloud.argon.repository.CategoriaHerramientaRepository;

import java.util.List;

@Service("CategoriaHerramientaImpl")
public class CategoriaHerramientaImpl implements CategoriaHerramientaPersistence {

    @Autowired
    @Qualifier("CategoriaHerramientaRepository")
    CategoriaHerramientaRepository categoriaHerramientaRepository;

    @Override
    public Object create(CategoriaHerramienta categoriaHerramienta) {
        return categoriaHerramientaRepository.save(categoriaHerramienta);
    }

    @Override
    public List<CategoriaHerramienta> getCategoriasHerramientas() {
        return categoriaHerramientaRepository.findAll();
    }

    @Override
    public CategoriaHerramienta getCategoriaHerramientaById(long id) {
        return categoriaHerramientaRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(CategoriaHerramienta categoriaHerramienta) {
        CategoriaHerramienta actualCategoriaHerramienta = getCategoriaHerramientaById(categoriaHerramienta.getId());
        actualCategoriaHerramienta.setName(categoriaHerramienta.getName());
        actualCategoriaHerramienta.setDescription(categoriaHerramienta.getDescription());
        actualCategoriaHerramienta.setupdatedAt(categoriaHerramienta.getupdatedAt());
        return categoriaHerramientaRepository.save(actualCategoriaHerramienta);
    }
}
