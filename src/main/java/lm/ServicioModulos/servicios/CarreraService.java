package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.modelos.repositorio.CarreraRepositorio;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private CarreraRepositorio carreraRepositorio;

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
}
