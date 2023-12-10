package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.HerramientaParticipante;
import vision2cloud.argon.persistence.HerramientaPersistence;
import vision2cloud.argon.repository.HerramientaRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("HerramientaImpl")
public class HerramientaImpl implements HerramientaPersistence {

    @Autowired
    @Qualifier("HerramientaRepository")
    HerramientaRepository herramientaRepository;

    @Override
    public Object create(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public List<Herramienta> getHerramientas() {
        return herramientaRepository.findAll();
    }

    @Override
    public List<Herramienta> getHerramientasByDisponible(String disponible) {
        return herramientaRepository.findByDisponibleLike(disponible);
    }

    @Override
    public Herramienta getHerramientaById(long id) {
        return herramientaRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public Herramienta findByCodigoBarras(String codigo_barras) {
        return herramientaRepository.findByCodigoBarras(codigo_barras);
    }

    @Override
    public List<Herramienta> findByMarca(String marca) {
        return herramientaRepository.findByMarca(marca);
    }

    @Override
    public List<Object> getEstadosForDasboard(List<HerramientaParticipante> herramientaParticipantes) {
        List<Object> response = new ArrayList<Object>();
        List<String> labels = new ArrayList<String>();
        List<Integer> data = new ArrayList<Integer>();
        List<Herramienta> disponibles = herramientaRepository.findByEstado("Disponible");
        List<Herramienta> noDisponibles = herramientaRepository.findByEstado("No disponible");
        labels.add("Disponibles: "+(disponibles.size() - herramientaParticipantes.size()));
        data.add(disponibles.size() - herramientaParticipantes.size());
        labels.add("Fuera de servicio: "+noDisponibles.size());
        data.add(noDisponibles.size());
        labels.add("Préstados: "+herramientaParticipantes.size());
        data.add(herramientaParticipantes.size());
        response.add(labels);
        response.add(data);
        return response;
    }

    @Override
    public Object createMasive(ArrayList<Herramienta> herramientas) {
        return herramientaRepository.saveAll(herramientas);
    }


}
