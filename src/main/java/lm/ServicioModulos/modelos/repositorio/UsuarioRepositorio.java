package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    
}
