package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.*;
import vision2cloud.argon.model.EmpresaReporte;
import vision2cloud.argon.persistence.Impl.ParticipanteImpl;
import vision2cloud.argon.persistence.Impl.TipoServicioImpl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
            System.out.println("-----------------");
            System.out.println("services");
            Participante participante1 = findByTipoDocumentoAndCedulaLike(participante.getTipoDocumento(), participante.getCedula());
            System.out.println(participante1);
            if(participante1 != null) {
                System.out.println("-----------------");
                System.out.println("update");
                participante.setId(participante1.getId());
                return participanteImpl.update(participante);
            }else{
                System.out.println("-----------------");
                System.out.println("create");
                return participanteImpl.create(participante);
            }

        }catch (Exception e){
            System.out.println("-----------------");
            System.out.println("exception");
            return participanteImpl.create(participante);
        }
    }
    public List<Participante> getParticipantes() {
        return participanteImpl.getParticipantes();
    }
    public Participante findByTipoDocumentoAndCedulaLike(String tipoDocumento,long cedula) {
        return participanteImpl.findByTipoDocumentoAndCedulaLike(tipoDocumento, cedula);
    }

    public Participante findByCedulaLike(long cedula) {
        return participanteImpl.findByCedulaLike(cedula);
    }
    public Participante getParticipanteById(long id) {
        return participanteImpl.getParticipanteById(id);
    }

    public List<Participante> getParticipanteToday() {
        LocalDate ld = LocalDate.now();
        Timestamp start = Timestamp.valueOf(ld.atStartOfDay());
        Timestamp end = Timestamp.valueOf(ld.plusDays(1).atStartOfDay());
        return participanteImpl.getParticipanteBetween(start, end);
    }

    public List<Object> countByTiposervicioAndCreatedAtBetween(Timestamp start, Timestamp end){
        List<TipoServicio> tipoServicios =tipoServicioImpl.getTiposServicios();
        return participanteImpl.countByTiposervicioAndCreatedAtBetween(start,end,tipoServicios);
    }

    public List<Participante> getParticipanteBetween(Timestamp start, Timestamp end) {
        return participanteImpl.getParticipanteBetween(start, end);
    }

    public List<EmpresaReporte> getEmpresasByParticipanteBetween(Timestamp start, Timestamp end) {
       /* List<Participante> participantes = participanteImpl.getParticipanteBetween(start, end);
        HashMap<String,EmpresaReporte> empresas = new HashMap<>();
        EmpresaReporte empresaReporte = null;
        String key = null;
        for(Participante participante: participantes){
            key = participante.getEmpresa().getNit();
            if(empresas.containsKey(key)){
                empresaReporte = empresas.get(key);
                empresaReporte.setDisponible(empresaReporte.getDisponible()+1);
                empresas.put(key, empresaReporte);
            }else{
                empresas.put(key, new EmpresaReporte(key,participante.getEmpresa().getNombre(),1));
            }
        }
        return new ArrayList<>(empresas.values());*/
        return null;

    }

    public List<Object> findDistinctByCedulaAndCreatedAtBetween(Timestamp start, Timestamp end) {
        return participanteImpl.findDistinctByCedulaAndCreatedAtBetween(start, end);
    }

    public Object update(Participante participante) {
        return participanteImpl.update(participante);
    }

    public List<Participante> findBetweenAndTipoServicio(Timestamp start, Timestamp end, String tiposervicio) {
        if(tiposervicio.equals("Todos")){
            return participanteImpl.getParticipanteBetween(start, end);
        }
        return participanteImpl.getParticipanteBetweenAndTipoServicio(start,end,tiposervicio);
    }

    public Object createMasive(ArrayList<Participante> participantes) {
        return participanteImpl.createMasive(participantes);
    }
}
