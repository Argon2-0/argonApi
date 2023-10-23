package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.VisitanteCurso;
import vision2cloud.argon.persistence.CursoPersistence;
import vision2cloud.argon.persistence.VisitanteCursoPersistence;
import vision2cloud.argon.repository.CursoRepository;
import vision2cloud.argon.repository.VistanteCursoRepository;

import java.util.ArrayList;
import java.util.List;

@Service("VisitanteCursoImpl")
public class VisitanteCursoImpl implements VisitanteCursoPersistence {
    @Autowired
    @Qualifier("VistanteCursoRepository")
    VistanteCursoRepository visitanteCursoRepository;

    @Override
    public Object create(VisitanteCurso visitanteCurso) {
        return visitanteCursoRepository.save(visitanteCurso);
    }

    @Override
    public List<VisitanteCurso> getVisitantesCursos() {
        return visitanteCursoRepository.findAll();
    }

    @Override
    public VisitanteCurso getVisitanteCursoById(Long id) {
        return visitanteCursoRepository.getById(id);
    }

    @Override
    public Object update(VisitanteCurso visitanteCurso) {
        VisitanteCurso actualVisitanteCurso = visitanteCursoRepository.getById(visitanteCurso.getId());
        actualVisitanteCurso.setCursoCodigo(visitanteCurso.getCursoCodigo());
        actualVisitanteCurso.setVisitanteId(visitanteCurso.getVisitanteId());
        return visitanteCursoRepository.save(actualVisitanteCurso);
    }

    @Override
    public Object createMasive(ArrayList<VisitanteCurso> cursos) {
        return visitanteCursoRepository.saveAll(cursos);
    }
}
