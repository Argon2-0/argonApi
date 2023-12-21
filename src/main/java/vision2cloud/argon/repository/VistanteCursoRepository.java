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
    VisitanteCurso getByVisitanteIdLike(long id);

    List<VisitanteCurso> findByDiaInicioBetweenOrDiaFinBetween(Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);

    List<VisitanteCurso> findByCursoCodigoLikeAndDiaInicioBetweenOrCursoCodigoLikeAndDiaFinBetween(String codigo1, Timestamp startInicio, Timestamp endInicio, String codigo2,  Timestamp startFin, Timestamp endFin);

}
