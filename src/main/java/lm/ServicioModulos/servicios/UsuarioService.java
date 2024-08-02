package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Usuario;
import lm.ServicioModulos.modelos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {

        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioId(Integer idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        return usuario;
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
        
    }
}
