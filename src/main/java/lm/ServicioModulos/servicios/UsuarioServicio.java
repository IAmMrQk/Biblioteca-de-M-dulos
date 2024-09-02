package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Usuario;
import lm.ServicioModulos.modelos.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
        return usuario;
    }

    public Usuario crearNuevoUsuario(Usuario usuario) {

        if (usuario.getContraseña() == null) {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }
        String contrasenaCodificada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contrasenaCodificada);
        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);

    }

    public Usuario autentificaion(String nombreUsuario, String contraseña) throws Exception {
        // Buscar el usuario por nombre de usuario
        Usuario usuario = usuarioRepositorio.findByusuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        // Comparar la contraseña proporcionada con la almacenada
        if (passwordEncoder.matches(contraseña, usuario.getContraseña())) {
            return usuario;
        } else {
            throw new Exception("Contraseña incorrecta");
        }
    }

}
