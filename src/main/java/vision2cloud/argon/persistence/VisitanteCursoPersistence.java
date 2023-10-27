package vision2cloud.argon.persistence;

import vision2cloud.argon.model.VisitanteCurso;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface VisitanteCursoPersistence {
    Object create(VisitanteCurso item);
    List<VisitanteCurso> getVisitantesCursos();
    VisitanteCurso getVisitanteCursoById(Long id);
    Object update(VisitanteCurso item);

    Object createMasive(ArrayList<VisitanteCurso> visitantesCursos);

    List<VisitanteCurso> findByDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end);
    List<VisitanteCurso> findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, String codigo);


}
