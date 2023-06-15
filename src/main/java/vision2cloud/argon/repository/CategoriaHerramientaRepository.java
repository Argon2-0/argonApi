package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.CategoriaHerramienta;

@Repository("CategoriaHerramientaRepository")
public interface CategoriaHerramientaRepository extends JpaRepository<CategoriaHerramienta,Integer> {
}
