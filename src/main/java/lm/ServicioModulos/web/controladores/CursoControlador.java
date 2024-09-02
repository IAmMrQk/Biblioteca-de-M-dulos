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
import java.util.stream.Collectors;

import lm.ServicioModulos.modelos.entidad.Cursos;

import lm.ServicioModulos.servicios.CursoService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/Cursos")  

public class CursoControlador {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/Lista_Cursos")
    public List<Cursos> obtenerCursos() {

        var cursos = cursoService.listarCursos();
        return cursos;
    }


    @PostMapping("/Guardar_Curso")
    public Cursos crearCurso(@RequestBody Cursos curso) {

        var cursoNuevo = cursoService.guardarCurso(curso);
        return cursoNuevo;
    }

    @PostMapping("/cursosPorIds")
    public ResponseEntity<List<Cursos>> obtenerCursosPorIds(@RequestBody List<Integer> ids) {
        List<Cursos> cursos = ids.stream()
                                 .map(cursoService::buscarCursoId)
                                 .filter(curso -> curso != null)
                                 .collect(Collectors.toList());
        return ResponseEntity.ok(cursos);
    }

    @PutMapping("/Editar_Curso/{idCurso}")
    public ResponseEntity<Cursos> editarCurso(@PathVariable Integer idCurso, @RequestBody Cursos cursoNuevo) {
        Cursos curso = cursoService.buscarCursoId(idCurso);

        if (curso == null) {
            throw new RuntimeException("El curso no existe");
        }

        curso.setNombreCurso(cursoNuevo.getNombreCurso());
        curso.setSemestreCurso(cursoNuevo.getSemestreCurso());
        curso.setDocumentos(cursoNuevo.getDocumentos());

        cursoService.guardarCurso(curso);

        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/Eliminar_Curso/{idCurso}")
    public ResponseEntity<Map<String, Boolean>> eliminarCurso(@PathVariable Integer idCurso) {
        Cursos curso = cursoService.buscarCursoId(idCurso);

        if (curso == null) {
            throw new RuntimeException("El curso que quieres eliminar no existe");
        }
        cursoService.eliminarCursos(curso);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Deleteado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
