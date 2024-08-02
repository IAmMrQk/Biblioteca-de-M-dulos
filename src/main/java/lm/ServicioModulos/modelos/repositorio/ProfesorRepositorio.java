package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer>{
    
}
