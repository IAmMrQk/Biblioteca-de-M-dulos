package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import lm.ServicioModulos.modelos.entidad.Estudiante;
import lm.ServicioModulos.modelos.repositorio.EstudianteRepositorio;

public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {

        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante buscarEstudianteId(Integer idEstudiante) {
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
        return estudiante;
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.delete(estudiante);

    }
}
