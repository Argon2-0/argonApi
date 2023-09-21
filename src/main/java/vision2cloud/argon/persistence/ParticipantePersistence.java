package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Migration;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface ParticipantePersistence {
    Object create(Participante participante);
    List<Participante> getParticipantes();
    Participante getParticipanteById(long id);
    Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento,long cedula);
    List<Participante> getParticipanteBetween(Timestamp start, Timestamp end);
    List<Object> countByTiposervicioAndCreatedAtBetween(Timestamp start, Timestamp end, List<TipoServicio> tipoServicios);

    List<Object> countByEdadAndCreatedAtBetween(Timestamp start, Timestamp end);

    List<Object> findBySexoLikeAndCreatedAtBetween(Timestamp start, Timestamp end);

    List<Object> findDistinctByCedulaAndCreatedAtBetween(Timestamp start, Timestamp end);

    Object update(Participante participante);

    List<Participante> getParticipanteBetweenAndTipoServicio(Timestamp start, Timestamp end, String tiposervicio);
}
