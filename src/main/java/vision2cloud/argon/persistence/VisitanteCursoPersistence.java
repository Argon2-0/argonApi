package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Curso;
import vision2cloud.argon.model.VisitanteCurso;

import java.util.ArrayList;
import java.util.List;

public interface VisitanteCursoPersistence {
    Object create(VisitanteCurso item);
    List<VisitanteCurso> getVisitantesCursos();
    VisitanteCurso getVisitanteCursoById(Long id);
    Object update(VisitanteCurso item);

    Object createMasive(ArrayList<VisitanteCurso> visitantesCursos);
}
