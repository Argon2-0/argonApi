package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.VisitanteCurso;

import java.sql.Timestamp;
import java.util.List;

@Repository("VistanteCursoRepository")
public interface VistanteCursoRepository extends JpaRepository<VisitanteCurso,Long> {

    List<VisitanteCurso> findByDiaInicioBetweenOrDiaFinBetween(Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);

    List<VisitanteCurso> findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(String codigo, Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);

}
