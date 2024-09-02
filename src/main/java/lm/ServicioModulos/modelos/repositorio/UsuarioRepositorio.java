package lm.ServicioModulos.modelos.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


import lm.ServicioModulos.modelos.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByusuario(String usuario);
}

/*
 * UsuarioRepositorio es una interfaz que actúa como un repositorio para la
 * entidad Usuario. Al extender JpaRepository, proporciona una variedad de
 * métodos para interactuar con la base de datos de forma sencilla y eficiente,
 * permitiendo realizar operaciones CRUD y consultas personalizadas sin
 * necesidad de implementar el código de acceso a datos manualmente.
 */
