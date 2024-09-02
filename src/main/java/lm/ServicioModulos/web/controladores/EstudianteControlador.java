package lm.ServicioModulos.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lm.ServicioModulos.modelos.entidad.Carrera;
import lm.ServicioModulos.modelos.entidad.Cursos;
import lm.ServicioModulos.modelos.entidad.Estudiante;
import lm.ServicioModulos.modelos.entidad.LoginRequest;
import lm.ServicioModulos.servicios.EstudianteService;
import lm.ServicioModulos.web.dto.CarreraDTO;
import lm.ServicioModulos.web.dto.CursoDto;
import lm.ServicioModulos.web.dto.EstudianteDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/Estudiantes")
public class EstudianteControlador {

    @Autowired
    public EstudianteService estudianteServicio;

    @GetMapping("/Lista_Estudiantes")
    public List<Estudiante> obtenerEstudiantes() {
        var estudiante = estudianteServicio.listarEstudiantes();
        return estudiante;
    }

    @PostMapping("/Agregar_Estudiante")
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        var nuevoEstudiante = estudianteServicio.guardarEstudiante(estudiante);
        return nuevoEstudiante;
    }

     @PostMapping("/estudiante_Login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Estudiante estudiante = estudianteServicio.autentificaion(loginRequest.getNombreUsuario(), loginRequest.getContraseña());

            // Convertir Carrera a CarreraDTO
            Carrera carrera = estudiante.getCarrera();
            List<CursoDto> cursoDtos = carrera.getCursosIntegrados().stream()
                    .map(curso -> new CursoDto(curso.getIdCurso(), curso.getNombreCurso()))
                    .collect(Collectors.toList());

            CarreraDTO carreraDTO = new CarreraDTO(carrera.getIdCarrera(), carrera.getNombreCarrera(), cursoDtos);

            // Crear el DTO de Estudiante
            EstudianteDTO estudianteDTO = new EstudianteDTO();
            estudianteDTO.setNombre(estudiante.getNombre());
            estudianteDTO.setApellido(estudiante.getApellido());
            estudianteDTO.setUsuario(estudiante.getUsuario());
            estudianteDTO.setSemestre(estudiante.getSemestre());
            estudianteDTO.setRol(estudiante.getRol());
            estudianteDTO.setCorreo(estudiante.getCorreo()); // Asegúrate de que el campo correo existe en Estudiante
            estudianteDTO.setCarrera(carreraDTO);
            estudianteDTO.setMatricula(estudiante.isMatricula());

            return ResponseEntity.ok(estudianteDTO);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/invertirMatricula/{id}")
    public ResponseEntity<?> invertirMatricula(@PathVariable Long id) {
        try {
            Estudiante estudianteActualizado = estudianteServicio.invertirMatricula(id);
            return ResponseEntity.ok(estudianteActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
