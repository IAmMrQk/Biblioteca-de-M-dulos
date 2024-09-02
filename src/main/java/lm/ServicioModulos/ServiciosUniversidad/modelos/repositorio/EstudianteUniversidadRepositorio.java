package lm.ServicioModulos.ServiciosUniversidad.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.ServiciosUniversidad.modelos.entidades.EstudiantesUniversidad;

public interface EstudianteUniversidadRepositorio extends JpaRepository<EstudiantesUniversidad, Long>{
    
    EstudiantesUniversidad findByCedula(String cedula);
}
