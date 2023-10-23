package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.VisitanteCurso;
import vision2cloud.argon.persistence.Impl.CursoImpl;
import vision2cloud.argon.persistence.Impl.VisitanteCursoImpl;

import java.util.ArrayList;
import java.util.List;

@Service("VisitanteCursoService")
public class VisitanteCursoService {
    @Autowired
    @Qualifier("VisitanteCursoImpl")
    VisitanteCursoImpl visitanteCursoImpl;

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
}
