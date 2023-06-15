package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HistoryTipoServicio;

import java.util.List;

public interface HistoryTipoServicioPersistence {
    Object create(HistoryTipoServicio historyTipoServicio);
    List<HistoryTipoServicio> getHistoryTiposServicios();
    HistoryTipoServicio getHistoryTipoServicioById(long id);
    Object update(HistoryTipoServicio historyTipoServicio);
}
