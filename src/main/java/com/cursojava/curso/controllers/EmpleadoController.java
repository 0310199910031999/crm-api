package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.EmpleadoDao;
import com.cursojava.curso.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {



    private EmpleadoDao empleadoDao;

    @Autowired
    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
    @RequestMapping(value = "crm/getEmpleados", method = RequestMethod.GET)
    public List<Empleado> getEmpleados(){
        return empleadoDao.getEmpleados();
    }

    @RequestMapping(value = "crm/setEmpleado", method = RequestMethod.POST)
    public void setEmpleado(@RequestBody Empleado empleado){
        empleadoDao.setEmpleado(empleado);
    }

    @RequestMapping(value = "crm/getEmpleado/{id}", method = RequestMethod.GET)
    public Empleado getEmpleado(@PathVariable int id){
        return empleadoDao.getEmpleado(id);
    }

    @RequestMapping(value = "crm/deleteEmpleado/{id}", method = RequestMethod.DELETE)
    public void deleteEmpleado(@PathVariable int id){
        empleadoDao.deleteEmpleado(id);
    }

    @RequestMapping(value = "crm/updateEmpleado", method = RequestMethod.PUT)
    public void updateEmpleado(@RequestBody Empleado empleado){
        empleadoDao.updateEmpleado(empleado);
    }
}
