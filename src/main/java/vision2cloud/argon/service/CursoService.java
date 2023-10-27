package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.persistence.Impl.CursoImpl;
import vision2cloud.argon.persistence.Impl.EmpresaImpl;

import java.util.ArrayList;
import java.util.List;

@Service("CursoService")
public class CursoService {
    @Autowired
    @Qualifier("CursoImpl")
    CursoImpl cursoImpl;

    public Object create(Curso item) {
        return cursoImpl.create(item);
    }

    public List<Curso> getCursos() {
        return cursoImpl.getCursos();
    }

    public Curso findByCodigoLike(String codigo) {
        return cursoImpl.findByCodigoLike(codigo);
    }

    public Object update(Curso item) {
        return cursoImpl.update(item);
    }

    public Object createMasive(ArrayList<Curso> cursos) {
        return cursoImpl.createMasive(cursos);
    }
}
