package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface HerramientaPersistence {
    Object create(Herramienta herramienta);
    List<Herramienta> getHerramientas();
    Herramienta getHerramientaById(long id);
    Object update(Herramienta herramienta);
    Herramienta findByCodigoBarras(String codigo_barras);
    List<Herramienta> findByMarca(String marca);
    List<Object> getEstadosForDasboard(List<HerramientaParticipante> herramientaParticipantes);
    Object createMasive(ArrayList<Herramienta> herramientas);
}
