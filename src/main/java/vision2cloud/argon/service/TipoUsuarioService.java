package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.TipoUsuario;
import vision2cloud.argon.persistence.Impl.TipoUsuarioImpl;

import java.util.List;

@Service("TipoUsuarioService")
public class TipoUsuarioService {
    @Autowired
    @Qualifier("TipoUsuarioImpl")
    TipoUsuarioImpl tipoUsuarioImpl;

    public Object create(TipoUsuario tipoUsuario) {
        return tipoUsuarioImpl.create(tipoUsuario);
    }

    public List<TipoUsuario> getTiposUsuarios() {
        return tipoUsuarioImpl.getTiposUsuarios();
    }

    public TipoUsuario getTipoUsuarioById(long id) {
        return tipoUsuarioImpl.getTipoUsuarioById(id);
    }

    public Object update(TipoUsuario tipoUsuario) {
        return tipoUsuarioImpl.update(tipoUsuario);
    }
}
