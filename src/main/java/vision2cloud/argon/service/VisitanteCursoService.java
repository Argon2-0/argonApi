package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.*;
import vision2cloud.argon.persistence.Impl.CursoImpl;
import vision2cloud.argon.persistence.Impl.ParticipanteImpl;
import vision2cloud.argon.persistence.Impl.VisitanteCursoImpl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("VisitanteCursoService")
public class VisitanteCursoService {
    @Autowired
    @Qualifier("VisitanteCursoImpl")
    VisitanteCursoImpl visitanteCursoImpl;

    @Autowired
    @Qualifier("ParticipanteImpl")
    ParticipanteImpl participanteImpl;

    @Autowired
    @Qualifier("CursoImpl")
    CursoImpl cursoImpl;

    public Object create(VisitanteCurso item) {
        return visitanteCursoImpl.create(item);
    }

    public List<VisitanteCurso> getVisitantesCursos() {
        return visitanteCursoImpl.getVisitantesCursos();
    }

    public VisitanteCurso getVisitanteCursoById(Long id) {
        return visitanteCursoImpl.getVisitanteCursoById(id);
    }
    public VisitanteCurso getByVisitanteId(Long id) {
        return visitanteCursoImpl.getByVisitanteId(id);
    }

    public Object update(VisitanteCurso item) {
        return visitanteCursoImpl.update(item);
    }

    public Object createMasive(ArrayList<RegistroCurso> cursos) {
        ArrayList<VisitanteCurso> visitanteCursos = new ArrayList<>();
        for (RegistroCurso registroCurso: cursos){
            visitanteCursos.add(
                    new VisitanteCurso(
                            participanteImpl.findByTipoDocumentoAndCedulaLike(registroCurso.getTipoDocumento(), registroCurso.getNumeroDocumento()).getId(),
                            registroCurso.getCodigo(),
                            registroCurso.getFechaInicio(),
                            registroCurso.getFechaFin()
                    )
            );
        }
        return visitanteCursoImpl.createMasive(visitanteCursos);
    }

    public List<CursoInforme> findBetweenAndCurso(Timestamp start, Timestamp end, String codigo) {
        List<VisitanteCurso> visitanteCursos = new ArrayList<>();
        List<CursoInforme> cursoInforme = new ArrayList<>();
        if(codigo.equals("Todos")){
            visitanteCursos = visitanteCursoImpl.findByDiaInicioBetweenOrDiaFinBetween(start, end);
        }
        else{
            visitanteCursos = visitanteCursoImpl.findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(start,end,codigo);
        }
        for(VisitanteCurso vistanteCurso: visitanteCursos){
            cursoInforme.add(new CursoInforme(vistanteCurso.getCursoCodigo(),
                    cursoImpl.findByCodigoLike(vistanteCurso.getCursoCodigo()).getNombre(),
                    participanteImpl.getParticipanteById(vistanteCurso.getVisitanteId()).getNombres()+ " "+ participanteImpl.getParticipanteById(vistanteCurso.getVisitanteId()).getApellidos()));
        }
        return  cursoInforme;
    }

    public List<Object> findBetween(Timestamp start, Timestamp end) {
        List<Curso> cursos = cursoImpl.getCursos();

        List<Object> response = new ArrayList<Object>();
        List<String> servicios = new ArrayList<String>();
        List<Integer> cantidad = new ArrayList<Integer>();
        Integer cuantos;
        for (Curso curso: cursos){
            System.out.println(curso.getCodigo());
            List<VisitanteCurso> visitanteCursos = visitanteCursoImpl.findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(start,end,curso.getCodigo());
            cuantos = visitanteCursos.size();
            System.out.println(visitanteCursos.size());
            servicios.add(curso.getNombre()+": "+cuantos);
            cantidad.add(cuantos);
        }
        response.add(servicios);
        response.add(cantidad);
        return response;
    }
}
