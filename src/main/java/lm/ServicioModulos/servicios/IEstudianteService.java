package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Estudiante;

public interface IEstudianteService {
    public List<Estudiante> listarEstudiantes();

    public Estudiante buscarEstudianteId(Integer idEstudiante);

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);
}
