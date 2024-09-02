package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Usuario;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();

    public Usuario buscarUsuarioId(Integer idUsuario);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);
}

/*
 * IUsuarioService es una interfaz que define métodos para gestionar la entidad
 * Usuario. Los métodos proporcionan operaciones básicas como listar, buscar,
 * guardar y eliminar usuarios. Implementar esta interfaz en una clase de
 * servicio permite separar la lógica de negocio de la lógica de acceso a datos,
 * facilitando la mantenibilidad y pruebas del código.
 */
