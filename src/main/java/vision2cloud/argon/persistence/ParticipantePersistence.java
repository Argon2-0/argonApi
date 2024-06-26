package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Migration;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ParticipantePersistence {
    Object create(Participante participante);
    List<Participante> getParticipantes();
    Participante getParticipanteById(long id);
    Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento,long cedula);

    Participante findByCedulaLike(long cedula);

    List<Participante> getParticipanteBetween(Timestamp start, Timestamp end);

    List<Object> findDistinctByCedulaAndCreatedAtBetween(Timestamp start, Timestamp end);

    Object update(Participante participante);

    Object createMasive(ArrayList<Participante> participantes);
}
