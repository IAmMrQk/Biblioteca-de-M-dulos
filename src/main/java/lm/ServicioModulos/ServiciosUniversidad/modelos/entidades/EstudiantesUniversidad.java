package lm.ServicioModulos.ServiciosUniversidad.modelos.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarioUniversity")
public class EstudiantesUniversidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Integer semestre;
    @Column(name = "matricula", columnDefinition = "BOOLEAN")
    private boolean matricula;
    private String carrera;
}
