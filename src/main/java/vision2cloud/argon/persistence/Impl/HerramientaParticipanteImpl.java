package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.persistence.HerramientaParticipantePersistence;
import vision2cloud.argon.repository.HerramientaParticipanteRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("HerramientaParticipanteImpl")
public class HerramientaParticipanteImpl implements HerramientaParticipantePersistence {

    @Autowired
    @Qualifier("HerramientaParticipanteRepository")
    HerramientaParticipanteRepository herramientaParticipanteRepository;

    @Override
    public Object create(HerramientaParticipante herramientaParticipante) {
        System.out.println("---------------------------------------");
        System.out.println("HerramientaParticipanteCreateImpl");
        System.out.println(herramientaParticipante.toString());
        System.out.println("---------------------------------------");
        System.out.println(new Date(herramientaParticipante.getCreatedAt().getTime()));
        return herramientaParticipanteRepository.save(herramientaParticipante);
    }

    @Override
    public List<HerramientaParticipante> getHerramientasParticipantes() {
        return herramientaParticipanteRepository.findAll();
    }

    @Override
    public HerramientaParticipante getHerramientaParticipanteById(long id) {
        return herramientaParticipanteRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public List<HerramientaParticipante> getHerramientaParticipanteToday() {
        LocalDate ld = LocalDate.now().minusYears(1);
        Timestamp start = Timestamp.valueOf(ld.atStartOfDay());
        Timestamp end = Timestamp.valueOf(ld.plusDays(1).atStartOfDay());
        return herramientaParticipanteRepository.findByCreatedAtBetween(start,end);
    }

    @Override
    public Object update(HerramientaParticipante herramientaParticipante) {
        System.out.println(new Date(herramientaParticipante.getCreatedAt().getTime()));
        System.out.println(new Date(herramientaParticipante.getUpdatedAt().getTime()));
        System.out.println(TimeUnit.HOURS.convert(herramientaParticipante.getUpdatedAt().getTime(),TimeUnit.MILLISECONDS));
        System.out.println(TimeUnit.HOURS.convert(herramientaParticipante.getCreatedAt().getTime(),TimeUnit.MILLISECONDS));
        System.out.println(TimeUnit.HOURS.convert(herramientaParticipante.getUpdatedAt().getTime(),TimeUnit.MILLISECONDS)+1-TimeUnit.HOURS.convert(herramientaParticipante.getCreatedAt().getTime(),TimeUnit.MILLISECONDS));
        System.out.println();
        herramientaParticipante.setTot_horas(TimeUnit.HOURS.convert(herramientaParticipante.getUpdatedAt().getTime()-herramientaParticipante.getCreatedAt().getTime(),TimeUnit.MILLISECONDS));

        herramientaParticipante.setEstado("Devuelto");
        return herramientaParticipanteRepository.save(herramientaParticipante);
    }

    @Override
    public HerramientaParticipante findByHerramientaIdAndEstado(Long herramienta_id, String estado) {
        return herramientaParticipanteRepository.findByHerramientaIdAndEstado(herramienta_id, estado);
    }

    @Override
    public List<HerramientaParticipante> findByEstado(String estado) {
        return herramientaParticipanteRepository.findByEstado(estado);
    }
    @Override
    public List<HerramientaParticipante> findByCreatedAtBetweenAndMarca(Timestamp start, Timestamp end, List<Herramienta> herramientasByMarca) {
        List<HerramientaParticipante> herramientaParticipantes = new ArrayList<HerramientaParticipante>();
        for (Herramienta herramienta: herramientasByMarca){
            herramientaParticipantes.addAll(herramientaParticipanteRepository.findByCreatedAtBetweenAndHerramientaId(start,end, herramienta.getId()));
        }
        return herramientaParticipantes;
    }

    @Override
    public List<HerramientaParticipante> getHerramientaCreatedAtBetween(Timestamp start, Timestamp end) {
        return herramientaParticipanteRepository.findByCreatedAtBetween(start,end);
    }

    @Override
    public List<Object> getDataForDashboard(Timestamp start, Timestamp end) {
        List<Object> response = new ArrayList<Object>();
        List<Long> cedulas = new ArrayList<>();
        List<HerramientaParticipante> herramientaParticipantes = herramientaParticipanteRepository.findByCreatedAtBetween(start,end);
        Long totalHoras = 0L;
        for (HerramientaParticipante herramientaParticipante: herramientaParticipantes){
            System.out.println( herramientaParticipante.getTot_horas());
            System.out.println( herramientaParticipante.getTot_horas()!=null);
            if(!cedulas.contains(herramientaParticipante.getParticipante().getCedula())){
                cedulas.add(herramientaParticipante.getParticipante().getCedula());
            }
            if(herramientaParticipante.getUpdatedAt()!=null && herramientaParticipante.getTot_horas()!=null){
                totalHoras+=herramientaParticipante.getTot_horas();
            }
            else{
                totalHoras+=TimeUnit.HOURS.convert(new Date().getTime()-herramientaParticipante.getCreatedAt().getTime(),TimeUnit.MILLISECONDS);
            }
        }
        response.add(cedulas.size());
        response.add(herramientaParticipantes.size());
        response.add(totalHoras);
        return response;
    }

    @Override
    public int findByParticipanteIdAndEstado(long participante, String estado) {
        return herramientaParticipanteRepository.findByParticipanteIdAndEstado(participante, estado).size();
    }

}
