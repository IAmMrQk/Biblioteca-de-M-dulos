package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Estudiante;
import lm.ServicioModulos.modelos.repositorio.EstudianteRepositorio;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        if (estudiante.getContraseña() == null) {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }
        String contrasenaCodificada = passwordEncoder.encode(estudiante.getContraseña());
        estudiante.setContraseña(contrasenaCodificada);
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante buscarEstudianteId(Long idEstudiante) {
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
        return estudiante;
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.delete(estudiante);

    }

    public Estudiante autentificaion(String nombreUsuario, String contraseña) throws Exception {
        // Buscar el usuario por nombre de usuario
        Estudiante estudiante = estudianteRepositorio.findByusuario(nombreUsuario)
                .orElseThrow(() -> new Exception("Estudiante no encontrado"));

        // Comparar la contraseña proporcionada con la almacenada
        if (passwordEncoder.matches(contraseña, estudiante.getContraseña())) {
            return estudiante;
        } else {
            throw new Exception("Contraseña incorrecta");
        }
    }

    public Estudiante invertirMatricula(Long idEstudiante) {
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        estudiante.setMatricula(!estudiante.isMatricula());
        return estudianteRepositorio.save(estudiante);
    }
}
