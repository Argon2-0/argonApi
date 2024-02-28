package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.VisitaVisitante;
import vision2cloud.argon.persistence.VisitaVisitantePersistence;
import vision2cloud.argon.repository.VisitaVisitanteRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("VisitaVisitaVisitanteImpl")
public class VisitaVisitaVisitanteImpl implements VisitaVisitantePersistence {
    @Autowired
    @Qualifier("VisitaVisitanteRepository")
    VisitaVisitanteRepository visitanteCursoRepository;

    @Override
    public Object create(VisitaVisitante visitaVisitante) {
        return visitanteCursoRepository.save(visitaVisitante);
    }

    @Override
    public List<VisitaVisitante> getVisitantesCursos() {
        return visitanteCursoRepository.findAll();
    }

    @Override
    public VisitaVisitante getVisitanteCursoById(Long id) {
        return visitanteCursoRepository.getById(id);
    }

    @Override
    public VisitaVisitante getByVisitanteId(Long id) {
        return visitanteCursoRepository.getByVisitanteIdLike(id);
    }

    @Override
    public Object update(VisitaVisitante visitaVisitante) {
        VisitaVisitante actualVisitaVisitante = visitanteCursoRepository.getById(visitaVisitante.getId());
        actualVisitaVisitante.setCurso(visitaVisitante.getCurso());
        actualVisitaVisitante.setVisitanteId(visitaVisitante.getVisitanteId());
        return visitanteCursoRepository.save(actualVisitaVisitante);
    }

    @Override
    public Object createMasive(ArrayList<VisitaVisitante> cursos) {
        return visitanteCursoRepository.saveAll(cursos);
    }

    @Override
    public List<VisitaVisitante> findByCursoCodigoLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, String codigo) {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(codigo);
        System.out.println(start);
        System.out.println(end);
        List<VisitaVisitante> vi = visitanteCursoRepository.findByDiaInicioBetweenOrDiaFinBetweenAndCursoCodigoLike(start, end, start, end, codigo);
        for (VisitaVisitante visitaVisitante : vi){
            System.out.println(visitaVisitante.toString());
        }
        return visitanteCursoRepository.findByDiaInicioBetweenOrDiaFinBetweenAndCursoCodigoLike(start, end, start, end, codigo);
    }

    @Override
    public List<VisitaVisitante> findByTipoServicioLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, long codigo) {
        return visitanteCursoRepository.findByTiposervicioIdAndDiaInicioBetweenOrDiaFinBetween(codigo, start, end, start, end);
    }

    @Override
    public List<VisitaVisitante> findByEmpesaLikeAndDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end, String codigo) {
        return visitanteCursoRepository.findByEmpresaNitAndDiaInicioBetweenOrDiaFinBetween(codigo, start, end, start, end);
    }

    @Override
    public List<VisitaVisitante> findByDiaInicioBetweenOrDiaFinBetween(Timestamp start, Timestamp end) {
        return visitanteCursoRepository.findByDiaInicioBetweenOrDiaFinBetween(start, end, start, end);
    }
}
