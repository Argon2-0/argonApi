package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.HistoryTipoServicio;
import vision2cloud.argon.persistence.HistoryTipoServicioPersistence;
import vision2cloud.argon.repository.HistoryTipoServicioRepository;

import java.util.List;

@Service("HistoryTipoServicioImpl")
public class HistoryTipoServicioImpl implements HistoryTipoServicioPersistence {

    @Autowired
    @Qualifier("HistoryTipoServicioRepository")
    HistoryTipoServicioRepository historyTipoServicioRepository;

    @Override
    public Object create(HistoryTipoServicio historyTipoServicio) {
        return historyTipoServicioRepository.save(historyTipoServicio);
    }

    @Override
    public List<HistoryTipoServicio> getHistoryTiposServicios() {
        return historyTipoServicioRepository.findAll();
    }

    @Override
    public HistoryTipoServicio getHistoryTipoServicioById(long id) {
        return historyTipoServicioRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(HistoryTipoServicio historyTipoServicio) {
        HistoryTipoServicio actualHistoryTipoServicio = getHistoryTipoServicioById(historyTipoServicio.getId());
        actualHistoryTipoServicio.setParticipante(historyTipoServicio.getParticipante());
        actualHistoryTipoServicio.setTiposervicio(historyTipoServicio.getTiposervicio());
        actualHistoryTipoServicio.setupdatedAt(historyTipoServicio.getupdatedAt());
        return historyTipoServicioRepository.save(actualHistoryTipoServicio);
    }
}
