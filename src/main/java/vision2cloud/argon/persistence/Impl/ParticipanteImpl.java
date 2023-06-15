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
    public Participante findByCedulaLike(long cedula) {
        return participanteRepository.findByCedulaLike(cedula);
    }

    @Override
    public List<Participante> getParticipanteBetween(Timestamp start, Timestamp end) {
        List<Participante> participantes = participanteRepository.findByCreatedAtBetween(start,end);
        for(Participante participante: participantes){
            System.out.println(participante.toString());
        }
        return participanteRepository.findByCreatedAtBetween(start,end);
    }

    @Override
    public List<Object> countByTiposervicioAndCreatedAtBetween(Timestamp start, Timestamp end,List<TipoServicio> tipoServicios) {
        List<Object> response = new ArrayList<Object>();
        List<String> servicios = new ArrayList<String>();
        List<Integer> cantidad = new ArrayList<Integer>();
        Integer cuantos;
        for (TipoServicio tipoServicio: tipoServicios){
            cuantos = participanteRepository.findByTiposervicioIdAndCreatedAtBetween(tipoServicio.getId(),start,end).size();
            servicios.add(tipoServicio.getNombre()+": "+cuantos);
            cantidad.add(cuantos);
        }
        response.add(servicios);
        response.add(cantidad);
        return response;
    }

    public List<Object> countByEdadAndCreatedAtBetween(Timestamp start, Timestamp end) {
        List<Object> response = new ArrayList<Object>();
        List<String> servicios = new ArrayList<String>();
        List<Integer> cantidad = new ArrayList<Integer>();
        Integer cuantos;
        ZoneId defaultZoneId = ZoneId.systemDefault();

        LocalDate hoy = LocalDate.now();
        System.out.println(hoy);
        System.out.println(hoy.minusYears(18));
        cuantos = participanteRepository.findByFechaNacimientoBetweenAndCreatedAtBetween(Timestamp.valueOf(hoy.minusYears(18).atStartOfDay()),Timestamp.valueOf(hoy.atStartOfDay()), start, end).size();
        servicios.add("Menores de 18 años: "+cuantos);
        cantidad.add(cuantos);
       cuantos = participanteRepository.findByFechaNacimientoBetweenAndCreatedAtBetween(Timestamp.valueOf(hoy.minusYears(26).atStartOfDay()),Timestamp.valueOf(hoy.minusYears(18).atStartOfDay()), start, end).size();
        servicios.add("Entre 18 y 25 años: "+cuantos);
        cantidad.add(cuantos);
        cuantos = participanteRepository.findByFechaNacimientoBetweenAndCreatedAtBetween(Timestamp.valueOf(hoy.minusYears(41).atStartOfDay()),Timestamp.valueOf(hoy.minusYears(26).atStartOfDay()), start, end).size();
        servicios.add("Entre 26 y 40 años: "+cuantos);
        cantidad.add(cuantos);
        cuantos = participanteRepository.findByFechaNacimientoBetweenAndCreatedAtBetween(Timestamp.valueOf(hoy.minusYears(61).atStartOfDay()),Timestamp.valueOf(hoy.minusYears(41).atStartOfDay()), start, end).size();
        servicios.add("Entre 41 y 60 años: "+cuantos);
        cantidad.add(cuantos);
        cuantos = participanteRepository.findByFechaNacimientoGreaterThanEqualAndCreatedAtBetween(Timestamp.valueOf(hoy.minusYears(61).atStartOfDay()), start, end).size();
        servicios.add("Mayores a 60 años: "+cuantos);
        cantidad.add(cuantos);
        response.add(servicios);
        response.add(cantidad);
        return response;
    }

    public List<Object> findBySexoLikeAndCreatedAtBetween(Timestamp start, Timestamp end) {
        List<Object> response = new ArrayList<Object>();
        List<String> servicios = new ArrayList<String>();
        List<Integer> cantidad = new ArrayList<Integer>();
        Integer cuantos;
        cuantos = participanteRepository.findBySexoLikeAndCreatedAtBetween("Hombre",start,end).size();
        servicios.add("Hombres: "+cuantos);
        cantidad.add(cuantos);
        cuantos = participanteRepository.findBySexoLikeAndCreatedAtBetween("Mujer",start,end).size();
        servicios.add("Mujeres: "+cuantos);
        cantidad.add(cuantos);
        response.add(servicios);
        response.add(cantidad);
        return response;
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
        Participante actualParticipante = getParticipanteById(participante.getId());
        actualParticipante.settipoDocumento(participante.gettipoDocumento());
        actualParticipante.setCedula(participante.getCedula());
        actualParticipante.setCelular(participante.getCelular());
        actualParticipante.setSexo(participante.getSexo());
        actualParticipante.setEmail(participante.getEmail());
        actualParticipante.setTiposervicio(participante.getTiposervicio());
        actualParticipante.setCurso(participante.getCurso());
        actualParticipante.settratDatos(participante.gettratDatos());
        actualParticipante.setEstado(participante.getEstado());
        actualParticipante.setupdatedAt(participante.getupdatedAt());
        return participanteRepository.save(actualParticipante);
    }
}
