package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Categorie;
import vision2cloud.argon.persistence.CategoriePersistence;
import vision2cloud.argon.repository.CategorieRepository;

import java.util.List;

@Service("CategorieImpl")
public class CategorieImpl implements CategoriePersistence {

    @Autowired
    @Qualifier("CategorieRepository")
    CategorieRepository categorieRepository;

    @Override
    public Object create(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(int id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Object update(Categorie categorie) {
        Categorie actualCategorie = getCategorieById(categorie.getId());
        actualCategorie.setName(categorie.getName());
        actualCategorie.setDescription(categorie.getDescription());
        actualCategorie.setupdatedAt(categorie.getupdatedAt());
        return categorieRepository.save(actualCategorie);
    }
}
