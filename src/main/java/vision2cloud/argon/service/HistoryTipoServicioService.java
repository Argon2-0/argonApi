package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.HistoryTipoServicio;
import vision2cloud.argon.persistence.Impl.HistoryTipoServicioImpl;

import java.util.List;

@Service("HistoryTipoServicioService")
public class HistoryTipoServicioService {
    @Autowired
    @Qualifier("HistoryTipoServicioImpl")
    HistoryTipoServicioImpl historyTipoServicioImpl;

    public Object create(HistoryTipoServicio historyTipoServicio) {
        return historyTipoServicioImpl.create(historyTipoServicio);
    }

    public List<HistoryTipoServicio> getHistoryTiposServicios() {
        return historyTipoServicioImpl.getHistoryTiposServicios();
    }

    public HistoryTipoServicio getHistoryTipoServicioById(long id) {
        return historyTipoServicioImpl.getHistoryTipoServicioById(id);
    }

    public Object update(HistoryTipoServicio historyTipoServicio) {
        return historyTipoServicioImpl.update(historyTipoServicio);
    }
}
