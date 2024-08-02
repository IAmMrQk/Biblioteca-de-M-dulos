package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Profesor;

public interface IProfesorService {
    public List<Profesor> listarProfesores();

    public Profesor buscarProfesorId(Integer idProfesor);

    public Profesor guardarProfesor(Profesor profesor);

    public void eliminarProfesor(Profesor profesor);
}
