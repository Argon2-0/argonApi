package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.persistence.Impl.ParticipanteImpl;
import vision2cloud.argon.persistence.Impl.TipoServicioImpl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service("ParticipanteService")
public class ParticipanteService {
    @Autowired
    @Qualifier("ParticipanteImpl")
    ParticipanteImpl participanteImpl;

    @Autowired
    @Qualifier("TipoServicioImpl")
    TipoServicioImpl tipoServicioImpl;

    public Object create(Participante participante) {
        try{
            Participante participante1 = findByTipoDocumentoAndCedulaLike(participante.gettipoDocumento(), participante.getCedula());
            participante.setId(participante1.getId());
            return participanteImpl.update(participante);
        }catch (Exception e){
            return participanteImpl.create(participante);
        }
    }
    public List<Participante> getParticipantes() {
        return participanteImpl.getParticipantes();
    }
    public Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento,long cedula) {
        System.out.println(participanteImpl.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula).getfechaNacimiento());
        System.out.println(participanteImpl.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula).getCreatedAt());
        return participanteImpl.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula);
    }
    public Participante getParticipanteById(long id) {
        return participanteImpl.getParticipanteById(id);
    }

    public List<Participante> getParticipanteToday() {
        LocalDate ld = LocalDate.now().minusYears(1).minusMonths(2);
        Timestamp start = Timestamp.valueOf(ld.atStartOfDay());
        Timestamp end = Timestamp.valueOf(ld.plusDays(1).atStartOfDay());
        return participanteImpl.getParticipanteBetween(start, end);
    }

    public List<Object> countByTiposervicioAndCreatedAtBetween(Timestamp start, Timestamp end){
        List<TipoServicio> tipoServicios =tipoServicioImpl.getTiposServicios();
        return participanteImpl.countByTiposervicioAndCreatedAtBetween(start,end,tipoServicios);
    }

    public List<Object> countByEdadAndCreatedAtBetween(Timestamp start, Timestamp end){
        return participanteImpl.countByEdadAndCreatedAtBetween(start,end);
    }

    public List<Object> findBySexoLikeAndCreatedAtBetween(Timestamp start, Timestamp end){
        return participanteImpl.findBySexoLikeAndCreatedAtBetween(start,end);
    }
    public List<Participante> getParticipanteBetween(Timestamp start, Timestamp end) {
        return participanteImpl.getParticipanteBetween(start, end);
    }

    public List<Object> findDistinctByCedulaAndCreatedAtBetween(Timestamp start, Timestamp end) {
        return participanteImpl.findDistinctByCedulaAndCreatedAtBetween(start, end);
    }

    public Object update(Participante participante) {
        return participanteImpl.update(participante);
    }
}
