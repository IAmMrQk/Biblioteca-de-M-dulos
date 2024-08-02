package lm.ServicioModulos.web.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.servicios.CarreraService;

@RestController
//Esto es una API
@RequestMapping("/Carreras")
public class CarreraControlador {
    
    @Autowired
    private CarreraService carreraService;

    @GetMapping("/Lista_Carreras")
    public List<Carrera> obtenerCarreras() {

        var carreras = carreraService.listarCarreras();
        return carreras;
    }
}
