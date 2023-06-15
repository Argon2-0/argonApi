package vision2cloud.argon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vision2cloud.argon.model.TipoUsuario;

@Repository("TipoUsuarioRepository")
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {
}
