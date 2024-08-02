package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{
    
}
