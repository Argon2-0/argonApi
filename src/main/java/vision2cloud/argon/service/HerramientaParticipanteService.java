package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.persistence.Impl.HerramientaImpl;
import vision2cloud.argon.persistence.Impl.HerramientaParticipanteImpl;
import vision2cloud.argon.persistence.Impl.ParticipanteImpl;

import java.sql.Timestamp;
import java.util.List;

@Service("HerramientaParticipanteService")
public class HerramientaParticipanteService {
    @Autowired
    @Qualifier("HerramientaParticipanteImpl")
    HerramientaParticipanteImpl herramientaParticipanteImpl;

    @Autowired
    @Qualifier("HerramientaImpl")
    HerramientaImpl herramientaImpl;
    @Autowired
    @Qualifier("ParticipanteImpl")
    ParticipanteImpl participanteImpl;
    public Object create(HerramientaParticipante herramientaParticipante) {
        System.out.println("---------------------------------------");
        System.out.println("HerramientaParticipanteCreateService");
        System.out.println(herramientaParticipante.toString());
        System.out.println("---------------------------------------");
        return herramientaParticipanteImpl.create(herramientaParticipante);
    }

    public List<HerramientaParticipante> getHerramientasParticipantes() {
        return herramientaParticipanteImpl.getHerramientasParticipantes();
    }

    public HerramientaParticipante getHerramientaParticipanteById(long id) {
        return herramientaParticipanteImpl.getHerramientaParticipanteById(id);
    }

    public List<HerramientaParticipante> getHerramientaParticipanteToday() {
        return herramientaParticipanteImpl.getHerramientaParticipanteToday();
    }

    public Object update(HerramientaParticipante herramientaParticipante) {

        return herramientaParticipanteImpl.update(herramientaParticipante);
    }

    public HerramientaParticipante findByHerramientaIdAndEstado(Long herramienta_id, String estado) {
        return herramientaParticipanteImpl.findByHerramientaIdAndEstado(herramienta_id, estado);
    }

    public List<HerramientaParticipante> findByEstado(String estado) {
        return herramientaParticipanteImpl.findByEstado(estado);
    }

    public List<HerramientaParticipante> findByCreatedAtBetweenAndMarca(Timestamp start, Timestamp end, String marca) {
        if(marca.equals("Todas")){
            return herramientaParticipanteImpl.getHerramientaCreatedAtBetween(start, end);
        }
        List<Herramienta> herramientasByMarca = herramientaImpl.findByMarca(marca);
        return herramientaParticipanteImpl.findByCreatedAtBetweenAndMarca(start,end,herramientasByMarca);
    }

    public List<Object> getDataForDashboard(Timestamp start, Timestamp end) {
        return herramientaParticipanteImpl.getDataForDashboard(start,end);
    }

    public int findByParticipanteIdAndEstado(String tipoDocumento, long documento, String estado){
        Participante participante = participanteImpl.findByTipoDocumentoAndCedulaLike(tipoDocumento, documento);
        return herramientaParticipanteImpl.findByParticipanteIdAndEstado(participante.getId(), estado);
    }
}
