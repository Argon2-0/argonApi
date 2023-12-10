package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.persistence.Impl.HerramientaImpl;
import vision2cloud.argon.persistence.Impl.HerramientaParticipanteImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("HerramientaService")
public class HerramientaService {
    @Autowired
    @Qualifier("HerramientaImpl")
    HerramientaImpl herramientaImpl;

    @Autowired
    @Qualifier("HerramientaParticipanteImpl")
    HerramientaParticipanteImpl herramientaParticipanteImpl;

    public Object create(Herramienta herramienta) {
        return herramientaImpl.create(herramienta);
    }

    public List<Herramienta> getHerramientas() {
        return herramientaImpl.getHerramientas();
    }

    public List<Herramienta> getHerramientasByDisponible(String disponible) {
        return herramientaImpl.getHerramientasByDisponible(disponible);
    }

    public Herramienta getHerramientaById(long id) {
        return herramientaImpl.getHerramientaById(id);
    }

    public Object update(Herramienta herramienta) {
        return herramientaImpl.update(herramienta);
    }

    public Herramienta findByCodigoBarras(String codigo_barras){return herramientaImpl.findByCodigoBarras(codigo_barras);}


    public List<Object> getEstadosForDasboard() {
        List<HerramientaParticipante> herramientaParticipantes = herramientaParticipanteImpl.findByEstado("Préstado");
        return  herramientaImpl.getEstadosForDasboard(herramientaParticipantes);
    }

    public Object createMasive(ArrayList<Herramienta> herramientas) {
        return  herramientaImpl.createMasive(herramientas);
    }
}
