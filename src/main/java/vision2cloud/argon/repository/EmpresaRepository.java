package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.Empresa;

@Repository("EmpresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
}
