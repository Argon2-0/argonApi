package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Herramienta;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;

import java.sql.Timestamp;
import java.util.List;

@Repository("HerramientaRepository")
public interface HerramientaRepository extends JpaRepository<Herramienta,Integer> {
    Herramienta findByCodigoBarras(String codigo_barras);
    List<Herramienta> findByMarca(String marca);
    List<Herramienta> findByEstado(String estado);
    List<Herramienta> findByDisponibleLike(String disponible);
}
