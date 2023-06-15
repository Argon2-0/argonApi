package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.HistoryTipoServicio;

@Repository("HistoryTipoServicioRepository")
public interface HistoryTipoServicioRepository extends JpaRepository<HistoryTipoServicio,Integer> {
}
