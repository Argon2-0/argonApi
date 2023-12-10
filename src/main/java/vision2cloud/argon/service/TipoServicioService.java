package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.persistence.Impl.TipoServicioImpl;

import java.util.ArrayList;
import java.util.List;

@Service("TipoServicioService")
public class TipoServicioService {
    @Autowired
    @Qualifier("TipoServicioImpl")
    TipoServicioImpl tipoServicioImpl;

    public Object create(TipoServicio tipoServicio) {
        return tipoServicioImpl.create(tipoServicio);
    }

    public List<TipoServicio> getTiposServicios() {
        return tipoServicioImpl.getTiposServicios();
    }
    public List<TipoServicio> getTiposServiciosByDisponible(String disponible) {
        return tipoServicioImpl.getTiposServiciosByDisponible(disponible);
    }

    public TipoServicio getTipoServicioById(long id) {
        return tipoServicioImpl.getTipoServicioById(id);
    }

    public Object update(TipoServicio tipoServicio) {
        return tipoServicioImpl.update(tipoServicio);
    }

    public Object createMasive(ArrayList<TipoServicio> tiposServicio) {
        return tipoServicioImpl.createMasive(tiposServicio);
    }
}
