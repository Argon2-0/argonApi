package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Categorie;

@Repository("CategorieRepository")
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
