package lm.ServicioModulos.web.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.servicios.CarreraService;

@RestController
//Esto es una API
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/Carreras")
public class CarreraControlador {
    
    @Autowired
    private CarreraService carreraService;

    @GetMapping("/Lista_Carreras")
    public List<Carrera> obtenerCarreras() {

        var carreras = carreraService.listarCarreras();
        return carreras;
    }

    @PostMapping("/Guardar_Carrera")
    public Carrera crearCarrera(@RequestBody Carrera carrera){

        var carreraNueva = carreraService.guardarCarreras(carrera);
        return carreraNueva;
    }

    @GetMapping("/{idCarrera}")
    public ResponseEntity <Carrera> obtenerCarreraPorId(@PathVariable Integer idCarrera){

        Carrera carrera = carreraService.buscarCarreraId(idCarrera);

        if(carrera == null){
            throw new RuntimeException("La carrera que buscas no se encuentra");
        }
        return ResponseEntity.ok(carrera);
    }

    //posible modificacion
    @PutMapping("/Editar_Carrera/{idCarrera}")
    public ResponseEntity <Carrera> editarCurso(@PathVariable Integer idCarrera, @RequestBody Carrera carreraNueva){
        Carrera carrera = carreraService.buscarCarreraId(idCarrera);

        if (carrera == null) {
            throw new RuntimeException("La carrera que buscas para editar no existe");
        }

        carrera.setNombreCarrera(carreraNueva.getNombreCarrera());
        carrera.setCantidadSemestre(carreraNueva.getCantidadSemestre());
        carrera.setCursosIntegrados(carreraNueva.getCursosIntegrados());

        carreraService.guardarCarreras(carrera);

        return ResponseEntity.ok(carrera);
    }

    @DeleteMapping("/Eliminar_Carrera/{idCarrera}")
    public ResponseEntity<Map<String, Boolean>> eliminarCarrera(@PathVariable Integer idCarrera){
        Carrera carrera = carreraService.buscarCarreraId(idCarrera);

        if (carrera == null) {
            throw new RuntimeException("El curso que quieres eliminar no existe");
        }
        carreraService.eliminarCarreras(carrera);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Deleteado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/Agregar_Curso_A_Carrera/{idCarrera}")
    public Carrera agregarCursoACarrera(@PathVariable Integer idCarrera, @RequestBody List<Integer> idDeCursos) {
        Carrera carrera = carreraService.agregarCursoACarrera(idCarrera, idDeCursos);
        return carrera;
    }
}
