package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.modelos.repositorio.CarreraRepositorio;

@Service
public class CarreraService implements ICarreraService{
    
    @Autowired
    private CarreraRepositorio CarreraRepositorio;

    @Override
    public List<Carrera> listarCarreras() {
        return CarreraRepositorio.findAll();
    }

    @Override
    public Carrera guardarCarreras(Carrera Carrera) {

        return CarreraRepositorio.save(Carrera);
    }

    @Override
    public Carrera buscarCarreraId(Integer idCarrera) {
        Carrera Carrera = CarreraRepositorio.findById(idCarrera).orElse(null);
        return Carrera;
    }

    @Override
    public void eliminarCarreras(Carrera Carrera) {
        CarreraRepositorio.delete(Carrera);
        
    }
}
