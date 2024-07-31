package lm.ServicioModulos.modelos.entidad;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private String telefono;
    private Carrera carrera;
    private Integer semestre;
    private Date fechaInscripcion;
    private String direccion;
    private Boolean estado;
    private String usuario;
    private String contreseña;
    private Rol rol;

}
