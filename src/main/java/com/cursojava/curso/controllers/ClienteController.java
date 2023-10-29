package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.ClienteDao;
import com.cursojava.curso.models.Cliente;
import com.mysql.cj.xdevapi.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private ClienteDao clienteDao;

    @Autowired
    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @RequestMapping(value = "crm/getClientes", method = RequestMethod.GET)
    public List<Cliente> getClientes(){
        return clienteDao.getClientes();
    }
    @RequestMapping(value = "crm/setCliente" , method = RequestMethod.POST)
    public void setCliente(@RequestBody Cliente cliente){
        clienteDao.setCliente(cliente);
    }

    @RequestMapping(value = "crm/getCliente/{id}", method = RequestMethod.GET)
    public Cliente getCliente(@PathVariable int id){
        return clienteDao.getCliente(id);
    }

    @RequestMapping(value =  "crm/deleteCliente/{id}", method = RequestMethod.DELETE)
    public void deleteCliente(@PathVariable int id){
        clienteDao.deleteCliente(id);
    }

    @RequestMapping(value = "crm/updateCliente", method = RequestMethod.PUT)
    public void updateCliente(@RequestBody Cliente cliente){
        clienteDao.updateCliente(cliente);
    }



}