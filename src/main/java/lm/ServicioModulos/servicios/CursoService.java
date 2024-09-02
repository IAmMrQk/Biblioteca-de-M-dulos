package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Cursos;
import lm.ServicioModulos.modelos.repositorio.CursosRepositorio;

@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private CursosRepositorio cursosRepositorio;

    @Override
    public List<Cursos> listarCursos() {
        return cursosRepositorio.findAll();
    }

    @Override
    public Cursos guardarCurso(Cursos Curso) {

        return cursosRepositorio.save(Curso);
    }
    

    @Override
    public Cursos buscarCursoId(Integer idCurso) {
        Cursos Curso = cursosRepositorio.findById(idCurso).orElse(null);
        return Curso;
    }

    @Override
    public void eliminarCursos(Cursos Curso) {
        cursosRepositorio.delete(Curso);
        
    }

    public List<Cursos> buscarCursosPorIds(List<Integer> ids) {
        return cursosRepositorio.findAllById(ids);
    }
}
