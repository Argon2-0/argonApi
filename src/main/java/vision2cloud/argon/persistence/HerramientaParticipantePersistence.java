package vision2cloud.argon.persistence;

import org.apache.ibatis.annotations.Param;
import vision2cloud.argon.model.CategoriaHerramienta;
import vision2cloud.argon.model.Categorie;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface HerramientaParticipantePersistence {
    Object create(HerramientaParticipante herramientaParticipante);
    List<HerramientaParticipante> getHerramientasParticipantes();

    HerramientaParticipante getHerramientaParticipanteById(long id);

    List<HerramientaParticipante> getHerramientaParticipanteToday();

    Object update(HerramientaParticipante herramientaParticipante);

    HerramientaParticipante findByHerramientaIdAndEstado(Long herramienta_id, String estado);

    List<HerramientaParticipante> findByEstado(String estado);

    List<HerramientaParticipante> findByCreatedAtBetweenAndMarca(Timestamp start, Timestamp end, List<Herramienta> herramientasByMarca);

    List<HerramientaParticipante> getHerramientaCreatedAtBetween(Timestamp start, Timestamp end);

    List<Object> getDataForDashboard(Timestamp start, Timestamp end);
}
