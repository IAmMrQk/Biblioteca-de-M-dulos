package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Carrera;

public interface ICarreraService {
    public List<Carrera> listarCarreras();

    public Carrera buscarCarreraId(Integer idCarrera);

    public Carrera guardarCarreras(Carrera Carrera);

    public void eliminarCarreras(Carrera Carrera);
}
