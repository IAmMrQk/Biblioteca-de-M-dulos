package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lm.ServicioModulos.modelos.entidad.Profesor;
import lm.ServicioModulos.modelos.repositorio.ProfesorRepositorio;

public class ProfesorService implements IProfesorService {
    
    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepositorio.findAll();
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {

        return profesorRepositorio.save(profesor);
    }

    @Override
    public Profesor buscarProfesorId(Integer idProfesor) {
        Profesor profesor = profesorRepositorio.findById(idProfesor).orElse(null);
        return profesor;
    }

    @Override
    public void eliminarProfesor(Profesor profesor) {
        profesorRepositorio.delete(profesor);

    }
}
