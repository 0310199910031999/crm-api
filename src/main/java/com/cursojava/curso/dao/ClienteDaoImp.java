package com.cursojava.curso.dao;

import com.cursojava.curso.models.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ClienteDaoImp implements ClienteDao{



    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Cliente getCliente(int id) {
        String query = "FROM Cliente where id = " + id;
        return entityManager.createQuery(query, Cliente.class).getSingleResult();
    }

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        String query = "FROM Cliente";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void setCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    @Transactional
    public void deleteCliente(int id) {
        String query = "FROM Cliente WHERE id = " + id;
        Cliente cliente = entityManager.createQuery(query, Cliente.class).getSingleResult();
        entityManager.remove(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        String query = "FROM Cliente where id =  :id";
        Cliente clienteU = entityManager.createQuery(query, Cliente.class)
                    .setParameter("id", cliente.getId())
                    .getSingleResult();
        clienteU = cliente.clone();
        entityManager.merge(clienteU);

    }
}



