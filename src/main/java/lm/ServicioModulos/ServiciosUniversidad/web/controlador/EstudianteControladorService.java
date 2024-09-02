package lm.ServicioModulos.ServiciosUniversidad.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lm.ServicioModulos.ServiciosUniversidad.modelos.entidades.EstudiantesUniversidad;
import lm.ServicioModulos.ServiciosUniversidad.servicios.EstudianteUniversidadService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/dataUniversidad")
public class EstudianteControladorService {
    
    @Autowired
    private EstudianteUniversidadService estudianteUniversidadService;

    @GetMapping("/existencia")
    public ResponseEntity<EstudiantesUniversidad> existenciaDeEstudiante(@RequestParam String cedula) {
        EstudiantesUniversidad estudiante = estudianteUniversidadService.buscarEstudiantePorCedula(cedula);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
