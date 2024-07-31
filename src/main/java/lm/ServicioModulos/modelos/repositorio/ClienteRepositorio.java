package lm.ServicioModulos.modelos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import lm.ServicioModulos.modelos.entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    
}
