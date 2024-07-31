package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Cursos;

public interface CursosRepositorio extends JpaRepository<Cursos, Integer>{
    
}
