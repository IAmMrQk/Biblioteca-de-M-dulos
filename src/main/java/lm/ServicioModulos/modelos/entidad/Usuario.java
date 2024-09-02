package lm.ServicioModulos.modelos.entidad;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // Genera un contructor con un parametro para cada campo en la clase
@NoArgsConstructor // Genera un contructor sin parametros
@Data // Genera getters, setters, toString(), hashCode(), y equals() automáticamente.
@Entity // indica que esta clase es una entidad JPA que se mapeará a una tabla en la
        // base de datos.
@DiscriminatorValue("USUARIO")
public class Usuario {  

    @Id // Indica que la clave primaria de la entidad es idUsuario
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    @ManyToOne // Indica una relacion de muchos a uno, muchos usuarios puede estar en una
               // carrera
    private Carrera carrera;
    @Column(name = "matricula", columnDefinition = "BOOLEAN")
    private boolean matricula;
    private String usuario;
    private String contraseña;
    private Rol rol;
}

/*
 * Esta clase es una parte esencial de la estructura de tu aplicación, ya que
 * define cómo se almacenan y gestionan los datos de los usuarios en la base de
 * datos.
 */
