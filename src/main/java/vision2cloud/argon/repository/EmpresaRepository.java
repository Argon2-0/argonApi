package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Empresa;
import vision2cloud.argon.model.TipoServicio;

import java.util.List;

@Repository("EmpresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
    List<Empresa> findByDisponibleLike(String disponible);
}
