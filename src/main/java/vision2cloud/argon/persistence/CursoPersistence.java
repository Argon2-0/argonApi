package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.Empresa;

import java.util.ArrayList;
import java.util.List;

public interface CursoPersistence {
    Object create(Curso item);
    List<Curso> getCursos();
    Curso findByCodigoLike(String codigo);
    Object update(Curso item);

    Object createMasive(ArrayList<Curso> cursos);
}
