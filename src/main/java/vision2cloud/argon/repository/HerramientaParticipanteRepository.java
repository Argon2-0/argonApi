package vision2cloud.argon.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("HerramientaParticipanteRepository")
public interface HerramientaParticipanteRepository extends JpaRepository<HerramientaParticipante,Integer> {
    List<HerramientaParticipante> findByCreatedAtBetween(Timestamp start, Timestamp end);
    HerramientaParticipante findByHerramientaIdAndEstado(Long herramienta_id, String estado);
    List<HerramientaParticipante> findByEstado(String estado);
    List<HerramientaParticipante> findByCreatedAtBetweenAndHerramientaId(Timestamp start, Timestamp end, Long herramientaID);
    List<HerramientaParticipante> findByParticipanteIdAndEstado(long participante, String estado);
}
