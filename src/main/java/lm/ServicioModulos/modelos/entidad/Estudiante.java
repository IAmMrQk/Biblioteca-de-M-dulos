package lm.ServicioModulos.modelos.entidad;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("ESTUDIANTE")

public class Estudiante extends Usuario{
    
    private Integer semestre;
    @OneToMany
    private List<Cursos> cursos;
}
