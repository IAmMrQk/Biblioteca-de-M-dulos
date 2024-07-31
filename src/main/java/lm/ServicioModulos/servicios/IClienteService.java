package lm.ServicioModulos.servicios;

import java.util.List;

import lm.ServicioModulos.modelos.entidad.Cliente;

public interface IClienteService {
    public List<Cliente> listarClientes();

    public Cliente buscarClienteId(Integer idCliente);

    public Cliente guardarClientes(Cliente cliente);

    public void eliminarClientes(Cliente cliente);
}
