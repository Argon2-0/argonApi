package vision2cloud.argon.persistence;

import vision2cloud.argon.model.TipoServicio;
import vision2cloud.argon.model.TipoUsuario;

import java.util.List;

public interface TipoUsuarioPersistence {
    Object create(TipoUsuario tipoUsuario);
    List<TipoUsuario> getTiposUsuarios();
    TipoUsuario getTipoUsuarioById(long id);
    Object update(TipoUsuario tipoUsuario);
}
