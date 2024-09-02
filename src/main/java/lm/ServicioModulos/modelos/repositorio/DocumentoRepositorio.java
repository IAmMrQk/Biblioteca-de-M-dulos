package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Documentos;

public interface DocumentoRepositorio extends JpaRepository<Documentos, Long> {
    
}
