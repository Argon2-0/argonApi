package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.CursoInforme;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.VisitanteCurso;
import vision2cloud.argon.persistence.Impl.CursoImpl;
import vision2cloud.argon.persistence.Impl.ParticipanteImpl;
import vision2cloud.argon.persistence.Impl.VisitanteCursoImpl;

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

    public Object update(VisitanteCurso item) {
        return visitanteCursoImpl.update(item);
    }

    public Object createMasive(ArrayList<VisitanteCurso> cursos) {
        return visitanteCursoImpl.createMasive(cursos);
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
}
