package lm.ServicioModulos.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Rol;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private Integer semestre;
    private Rol rol;
    private CarreraDTO carrera;
    private boolean matricula;
}
