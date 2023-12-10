package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Participante;
import vision2cloud.argon.model.TipoServicio;

import java.sql.Timestamp;
import java.util.List;

@Repository("TipoServicioRepository")
public interface TipoServicioRepository extends JpaRepository<TipoServicio,Integer> {
    List<TipoServicio> findByDisponibleLike(String disponible);
}
