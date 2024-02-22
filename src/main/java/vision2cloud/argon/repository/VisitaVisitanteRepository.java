package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.VisitaVisitante;

import java.sql.Timestamp;
import java.util.List;

@Repository("VisitaVisitanteRepository")
public interface VisitaVisitanteRepository extends JpaRepository<VisitaVisitante,Long> {
    VisitaVisitante getByVisitanteIdLike(long id);

    List<VisitaVisitante> findByDiaInicioBetweenOrDiaFinBetween(Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);

    List<VisitaVisitante> findByCursoCodigoAndDiaInicioBetweenOrDiaFinBetween(String codigo1, Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);

    List<VisitaVisitante> findByTiposervicioIdAndDiaInicioBetweenOrDiaFinBetween(long codigo1, Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);
    List<VisitaVisitante> findByEmpresaNitAndDiaInicioBetweenOrDiaFinBetween(String codigo1, Timestamp startInicio, Timestamp endInicio, Timestamp startFin, Timestamp endFin);
}
