package com.cursojava.curso.dao;

import com.cursojava.curso.models.Empleado;
import org.hibernate.boot.model.source.spi.EmbeddableMapping;

import java.util.List;

public interface EmpleadoDao {
    List<Empleado> getEmpleados();

    void setEmpleado(Empleado empleado);

    void deleteEmpleado(int id);

    Empleado getEmpleado(int id);

    void updateEmpleado(Empleado empleado);

}
