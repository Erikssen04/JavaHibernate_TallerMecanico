package org.example.DAO;

import org.example.models.Cliente;

import java.util.List;

public interface ClienteDAO {

    // Métodos CRUD
    void createCliente(Cliente cliente);
    Cliente findCliente(int cliente_id);
    List<Cliente> findAllClientes();
    void updateCliente (Cliente cliente);
    void deleteCliente (int cliente_id);

}
