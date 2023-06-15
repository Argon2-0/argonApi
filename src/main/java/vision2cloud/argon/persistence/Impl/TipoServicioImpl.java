package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.persistence.TipoServicioPersistence;
import vision2cloud.argon.repository.TipoServicioRepository;

import java.util.ArrayList;
import java.util.List;

@Service("TipoServicioImpl")
public class TipoServicioImpl implements TipoServicioPersistence {

    @Autowired
    @Qualifier("TipoServicioRepository")
    TipoServicioRepository tipoServicioRepository;

    @Override
    public Object create(TipoServicio tipoServicio) {
        return tipoServicioRepository.save(tipoServicio);
    }

    @Override
    public List<TipoServicio> getTiposServicios() {
        return tipoServicioRepository.findAll();
    }

    @Override
    public TipoServicio getTipoServicioById(long id) {
        return tipoServicioRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(TipoServicio tipoServicio) {
        TipoServicio actualTipoServicio = getTipoServicioById(tipoServicio.getId());
        actualTipoServicio.setNombre(tipoServicio.getNombre());
        actualTipoServicio.setDescripcion(tipoServicio.getDescripcion());
        actualTipoServicio.setupdatedAt(tipoServicio.getupdatedAt());
        actualTipoServicio.setForm(tipoServicio.getForm());
        return tipoServicioRepository.save(actualTipoServicio);
    }

    @Override
    public Object createMasive(ArrayList<TipoServicio> tiposServicio) {
        return tipoServicioRepository.saveAll(tiposServicio);
    }
}
