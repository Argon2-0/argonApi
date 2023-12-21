package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.model.Participante;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository("ParticipanteRepository")
public interface ParticipanteRepository extends JpaRepository<Participante,Integer> {
    List<Participante> findByCreatedAtBetween(Timestamp start, Timestamp end);
    Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento, Long documento);
    Participante findByCedulaLike(Long documento);
    List<Participante> findByTiposervicioIdAndCreatedAtBetween(Long TiposevicioId,Timestamp start, Timestamp end);
    List<Participante> findByFechaNacimientoBetweenAndCreatedAtBetween(Timestamp start, Timestamp end, Timestamp startRegistro, Timestamp endRegistro);
    List<Participante> findBySexoLikeAndCreatedAtBetween(String sexo, Timestamp start, Timestamp end);

}
