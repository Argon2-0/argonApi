package vision2cloud.argon.persistence;

import vision2cloud.argon.model.CategoriaHerramienta;
import vision2cloud.argon.model.Categorie;

import java.util.List;

public interface CategoriePersistence {
    Object create(Categorie categorie);
    List<Categorie> getCategories();
    Categorie getCategorieById(int id);
    Object update(Categorie categorie);
}
