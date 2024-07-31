package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Cursos;

public interface ICursoService {
    public List<Cursos> listarCursos();

    public Cursos buscarCursoId(Integer idCursos);

    public Cursos guardarCurso(Cursos curso);

    public void eliminarCursos(Cursos curso);
}
