package vision2cloud.argon.persistence;

import vision2cloud.argon.model.CategoriaHerramienta;

import java.util.List;

public interface CategoriaHerramientaPersistence {
    Object create(CategoriaHerramienta categoriaHerramienta);
    List<CategoriaHerramienta> getCategoriasHerramientas();
    CategoriaHerramienta getCategoriaHerramientaById(long id);
    Object update(CategoriaHerramienta categoriaHerramienta);
}
