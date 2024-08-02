package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Usuario;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();

    public Usuario buscarUsuarioId(Integer idUsuario);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);
}
