package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.persistence.ParticipantePersistence;
import vision2cloud.argon.repository.ParticipanteRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service("ParticipanteImpl")
public class ParticipanteImpl implements ParticipantePersistence {

    @Autowired
    @Qualifier("ParticipanteRepository")
    ParticipanteRepository participanteRepository;

    @Override
    public Object create(Participante participante) {
        System.out.println("-----------------");
        System.out.println("repesotory create");
        return participanteRepository.save(participante);
    }

    @Override
    public List<Participante> getParticipantes() {
        return participanteRepository.findAll();
    }

    @Override
    public Participante getParticipanteById(long id) {
        return participanteRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento,long cedula) {
        return participanteRepository.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula);
    }

    @Override
    public Participante findByCedulaLike(long cedula) {
        return participanteRepository.findByCedulaLike(cedula);
    }


    @Override
    public List<Participante> getParticipanteBetween(Timestamp start, Timestamp end) {
        return participanteRepository.findByCreatedAtBetweenOrUpdatedAtBetween(start,end, start,end);
    }


    @Override
    public List<Object> findDistinctByCedulaAndCreatedAtBetween(Timestamp start, Timestamp end) {
        List<Object> response = new ArrayList<Object>();
        List<Long> cedulas = new ArrayList<>();
        List<Participante> participantes= participanteRepository.findByCreatedAtBetween(start,end);
        for(Participante participante: participantes){
            if(!cedulas.contains(participante.getCedula())){
                cedulas.add(participante.getCedula());
            }
        }
        System.out.println(cedulas);
        response.add(cedulas.size());
        response.add(participantes.size());
        return response;
    }

    @Override
    public Object update(Participante participante) {
        System.out.println("-----------------");
        System.out.println("repesotory update");
        Participante actualParticipante = getParticipanteById(participante.getId());
        actualParticipante.setCelular(participante.getCelular());
        actualParticipante.setEmail(participante.getEmail());
        actualParticipante.setTratDatos(participante.getTratDatos());
        actualParticipante.setEstado(participante.getEstado());
        actualParticipante.setUpdatedAt(participante.getUpdatedAt());
        return participanteRepository.save(actualParticipante);
    }

    @Override
    public Object createMasive(ArrayList<Participante> participantes) {
        return participanteRepository.saveAll(participantes);
    }
}
