package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Cursos;
import lm.ServicioModulos.modelos.repositorio.CursosRepositorio;

@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private CursosRepositorio CursosRepositorio;

    @Override
    public List<Cursos> listarCursos() {
        return CursosRepositorio.findAll();
    }

    @Override
    public Cursos guardarCurso(Cursos Curso) {

        return CursosRepositorio.save(Curso);
    }

    @Override
    public Cursos buscarCursoId(Integer idCurso) {
        Cursos Curso = CursosRepositorio.findById(idCurso).orElse(null);
        return Curso;
    }

    @Override
    public void eliminarCursos(Cursos Curso) {
        CursosRepositorio.delete(Curso);
        
    }
}
