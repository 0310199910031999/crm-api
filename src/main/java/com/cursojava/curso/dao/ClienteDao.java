package com.cursojava.curso.dao;

import com.cursojava.curso.models.Cliente;


import java.util.List;

public interface ClienteDao {
    List<Cliente> getClientes();

    void setCliente(Cliente cliente);

    Cliente getCliente(int id);

    void deleteCliente(int id);

    void updateCliente(Cliente cliente);


}
