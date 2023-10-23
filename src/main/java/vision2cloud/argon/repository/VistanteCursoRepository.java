package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.VisitanteCurso;

@Repository("VistanteCursoRepository")
public interface VistanteCursoRepository extends JpaRepository<VisitanteCurso,Long> {
}
