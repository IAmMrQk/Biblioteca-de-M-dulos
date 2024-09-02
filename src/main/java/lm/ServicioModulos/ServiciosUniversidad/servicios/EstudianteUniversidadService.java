package lm.ServicioModulos.ServiciosUniversidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.ServiciosUniversidad.modelos.entidades.EstudiantesUniversidad;
import lm.ServicioModulos.ServiciosUniversidad.modelos.repositorio.EstudianteUniversidadRepositorio;

@Service
public class EstudianteUniversidadService {
    
    @Autowired
    private EstudianteUniversidadRepositorio estudianteUniversidadRepositorio;

    public EstudiantesUniversidad buscarEstudiantePorCedula(String cedula){
        return estudianteUniversidadRepositorio.findByCedula(cedula);
    }
}
