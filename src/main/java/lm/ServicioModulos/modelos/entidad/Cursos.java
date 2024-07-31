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
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCusro;
    private String nombreCurso;
    private Date fecheInicio;
    private Date fechaFinalizacion;
    private Integer semestreCurso;
    private String contenido;
}
