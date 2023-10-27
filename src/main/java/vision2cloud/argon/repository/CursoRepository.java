package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.CursoInforme;
import vision2cloud.argon.model.Empresa;

@Repository("CursoRepository")
public interface CursoRepository extends JpaRepository<Curso,String> {
    Curso findByCodigoLike(String codigo);
}
