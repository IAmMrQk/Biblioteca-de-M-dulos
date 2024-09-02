package lm.ServicioModulos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.modelos.entidad.Cursos;
import lm.ServicioModulos.modelos.repositorio.CarreraRepositorio;
import lm.ServicioModulos.modelos.repositorio.CursosRepositorio;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private CarreraRepositorio carreraRepositorio;

    @Autowired
    private CursosRepositorio cursosRepositorio;

    @Override
    public List<Carrera> listarCarreras() {
        return carreraRepositorio.findAll();
    }

    @Override
    public Carrera guardarCarreras(Carrera carrera) {

        return carreraRepositorio.save(carrera);
    }

    @Override
    public Carrera buscarCarreraId(Integer idCarrera) {
        Carrera Carrera = carreraRepositorio.findById(idCarrera).orElse(null);
        return Carrera;
    }

    @Override
    public void eliminarCarreras(Carrera carrera) {
        carreraRepositorio.delete(carrera);
    }

    public Carrera agregarCursoACarrera(Integer idCarrera, List<Integer> idsDeCursos){

        Optional<Carrera> carreraOptional = carreraRepositorio.findById(idCarrera);

        if (carreraOptional.isPresent()) {
            
            Carrera carrera = carreraOptional.get();

            for (Integer cursoId : idsDeCursos){

                Optional<Cursos> cursoOptional = cursosRepositorio.findById(cursoId);

                if (cursoOptional.isPresent()) {
                    Cursos curso = cursoOptional.get();
                    carrera.getCursosIntegrados().add(curso);
                }else {
                    throw new RuntimeException("Curso con Id " + cursoId + " No fue encontrado");
                }
            }

            return carreraRepositorio.save(carrera);
        }else {
            throw new RuntimeException("La carrera con id " + idCarrera + "no fue encontrada");
        }
    }
}
