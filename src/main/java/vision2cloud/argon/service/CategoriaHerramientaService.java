package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.CategoriaHerramienta;
import vision2cloud.argon.persistence.Impl.CategoriaHerramientaImpl;

import java.util.List;

@Service("CategoriaHerramientaService")
public class CategoriaHerramientaService {
    @Autowired
    @Qualifier("CategoriaHerramientaImpl")
    CategoriaHerramientaImpl categoriaHerramientaImpl;

    public Object create(CategoriaHerramienta categoriaHerramienta) {
        return categoriaHerramientaImpl.create(categoriaHerramienta);
    }

    public List<CategoriaHerramienta> getCategoriasHerramientas() {
        System.out.println("Service");
        return categoriaHerramientaImpl.getCategoriasHerramientas();
    }

    public CategoriaHerramienta getCategoriaHerramientaById(long id) {
        return categoriaHerramientaImpl.getCategoriaHerramientaById(id);
    }

    public Object update(CategoriaHerramienta categoriaHerramienta) {
        return categoriaHerramientaImpl.update(categoriaHerramienta);
    }
}
