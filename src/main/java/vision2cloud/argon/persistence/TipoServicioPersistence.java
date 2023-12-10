package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Tag;
import vision2cloud.argon.model.TipoServicio;

import java.util.ArrayList;
import java.util.List;

public interface TipoServicioPersistence {
    Object create(TipoServicio tipoServicio);
    List<TipoServicio> getTiposServicios();
    List<TipoServicio> getTiposServiciosByDisponible(String disponible);
    TipoServicio getTipoServicioById(long id);
    Object update(TipoServicio tipoServicio);
    Object createMasive(ArrayList<TipoServicio> tiposServicio);
}
