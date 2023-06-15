package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Categorie;
import vision2cloud.argon.persistence.Impl.CategorieImpl;

import java.util.List;

@Service("CategorieService")
public class CategorieService {
    @Autowired
    @Qualifier("CategorieImpl")
    CategorieImpl categorieImpl;

    public Object create(Categorie categorie) {
        return categorieImpl.create(categorie);
    }

    public List<Categorie> getCategories() {
        return categorieImpl.getCategories();
    }

    public Categorie getCategorieById(int id) {
        return categorieImpl.getCategorieById(id);
    }

    public Object update(Categorie categorie) {
        return categorieImpl.update(categorie);
    }
}
