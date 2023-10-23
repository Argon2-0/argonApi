package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.persistence.CursoPersistence;
import vision2cloud.argon.persistence.EmpresaPersistence;
import vision2cloud.argon.repository.CursoRepository;
import vision2cloud.argon.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;

@Service("CursoImpl")
public class CursoImpl implements CursoPersistence {
    @Autowired
    @Qualifier("CursoRepository")
    CursoRepository cursoRepository;

    @Override
    public Object create(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoByCodigo(String codigo) {
        List<Curso> cursos = cursoRepository.findAll();
        for (Curso curso: cursos){
            if (curso.getCodigo() == codigo){
                return curso;
            }
        }
        return null;
    }

    @Override
    public Object update(Curso curso) {
        Curso actualCurso = getCursoByCodigo(curso.getCodigo());
        actualCurso.setNombre(curso.getNombre());
        return cursoRepository.save(actualCurso);
    }

    @Override
    public Object createMasive(ArrayList<Curso> cursos) {
        return cursoRepository.saveAll(cursos);
    }
}
