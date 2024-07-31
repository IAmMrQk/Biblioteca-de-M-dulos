package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Carrera;

public interface CarreraRepositorio extends JpaRepository<Carrera, Integer> {
    
}
