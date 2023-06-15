package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.TipoServicio;

@Repository("TipoServicioRepository")
public interface TipoServicioRepository extends JpaRepository<TipoServicio,Integer> {
}
