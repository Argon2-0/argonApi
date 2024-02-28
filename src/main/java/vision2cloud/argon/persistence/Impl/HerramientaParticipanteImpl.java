package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.persistence.HerramientaParticipantePersistence;
import vision2cloud.argon.repository.HerramientaParticipanteRepository;

import java.sql.Timestamp;
import java.time.*;
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
        ZoneId zonaColombia = ZoneId.of("America/Bogota");
        ZonedDateTime nowColombia = ZonedDateTime.now(zonaColombia);
        LocalDate ld = nowColombia.toLocalDate();
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
    public List<Object> getDataForDashboard(Timestamp startTime, Timestamp endTime) {
        Instant instantStart = startTime.toInstant();
        Instant instantEnd = endTime.toInstant();
        ZoneId zonaColombia = ZoneId.of("America/Bogota");
        ZonedDateTime zonedDateTimeStart = instantStart.atZone(zonaColombia);
        ZonedDateTime zonedDateTimeEnd = instantEnd.atZone(zonaColombia);
        // Convertir el Timestamp a LocalDateTime
        LocalDateTime localDateTimeStart = zonedDateTimeStart.toLocalDateTime().withHour(0).withMinute(0).withSecond(0).withNano(0);
        // Convertir el LocalDateTime de nuevo a Timestamp
        Timestamp startTimestamp = Timestamp.valueOf(localDateTimeStart);
        // Convertir el Timestamp a LocalDateTime
        LocalDateTime localDateTimeEnd = zonedDateTimeEnd.toLocalDateTime().withHour(0).withMinute(0).withSecond(0).withNano(0);
        // Convertir el LocalDateTime de nuevo a Timestamp
        Timestamp endTimestamp = Timestamp.valueOf(localDateTimeEnd);
        List<Object> response = new ArrayList<Object>();
        List<Long> cedulas = new ArrayList<>();
        List<HerramientaParticipante> herramientaParticipantes = herramientaParticipanteRepository.findByCreatedAtBetween(startTimestamp,endTimestamp);
        Long totalHoras = 0L;
        for (HerramientaParticipante herramientaParticipante: herramientaParticipantes){
            System.out.println( herramientaParticipante.getTot_horas());
            System.out.println( herramientaParticipante.getTot_horas()!=null);
            if(!cedulas.contains(herramientaParticipante.getParticipante().getCedula())){
                cedulas.add(herramientaParticipante.getParticipante().getCedula());
            }
        }
        response.add(cedulas.size());
        response.add(herramientaParticipantes.size());
        return response;
    }

    @Override
    public int findByParticipanteIdAndEstado(long participante, String estado) {
        return herramientaParticipanteRepository.findByParticipanteIdAndEstado(participante, estado).size();
    }

}
