package lm.ServicioModulos.modelos.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByusuario(String usuario);
}
