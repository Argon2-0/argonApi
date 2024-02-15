package vision2cloud.argon.persistence;

import vision2cloud.argon.model.VisitaVisitante;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface VisitaVisitantePersistence {
    Object create(VisitaVisitante item);
    List<VisitaVisitante> getVisitantesCursos();
    VisitaVisitante getVisitanteCursoById(Long id);

    VisitaVisitante getByVisitanteId(Long id);

    Object update(VisitaVisitante item);

    Object createMasive(ArrayList<VisitaVisitante> visitantesCursos);
    List<VisitaVisitante> findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, String codigo);
    List<VisitaVisitante> findByTipoServicioLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, long codigo);
    List<VisitaVisitante> findByEmpesaLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, String codigo);
    List<VisitaVisitante> findByDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end);

}
