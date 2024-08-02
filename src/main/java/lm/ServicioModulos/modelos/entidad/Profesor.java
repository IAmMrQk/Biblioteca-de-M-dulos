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
@DiscriminatorValue("PROFESOR")

public class Profesor extends Usuario{
    
    @OneToMany
    private List<Cursos> cursos;
}
