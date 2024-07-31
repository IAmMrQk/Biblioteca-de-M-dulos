package lm.ServicioModulos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Cliente;
import lm.ServicioModulos.modelos.repositorio.ClienteRepositorio;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardarClientes(Cliente cliente) {

        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente buscarClienteId(Integer idCliente) {
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void eliminarClientes(Cliente cliente) {
        clienteRepositorio.delete(cliente);
        
    }
}
