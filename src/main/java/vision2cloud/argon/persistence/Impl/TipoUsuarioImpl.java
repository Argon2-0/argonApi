package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.TipoUsuario;
import vision2cloud.argon.persistence.TipoUsuarioPersistence;
import vision2cloud.argon.repository.TipoUsuarioRepository;

import java.util.List;

@Service("TipoUsuarioImpl")
public class TipoUsuarioImpl implements TipoUsuarioPersistence {

    @Autowired
    @Qualifier("TipoUsuarioRepository")
    TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public Object create(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public List<TipoUsuario> getTiposUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario getTipoUsuarioById(long id) {
        return tipoUsuarioRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(TipoUsuario tipoUsuario) {
        TipoUsuario actualTipoUsuario = getTipoUsuarioById(tipoUsuario.getId());
        actualTipoUsuario.setNombre(tipoUsuario.getNombre());
        actualTipoUsuario.setDescripcion(tipoUsuario.getDescripcion());
        actualTipoUsuario.setupdatedAt(tipoUsuario.getupdatedAt());
        return tipoUsuarioRepository.save(actualTipoUsuario);
    }
}
