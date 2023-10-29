package com.cursojava.curso.dao;

import com.cursojava.curso.models.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmpleadoDaoImp implements EmpleadoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Empleado> getEmpleados() {
        String query = "FROM Empleado";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void setEmpleado(Empleado empleado) {
        entityManager.merge(empleado);
    }

    @Override
    public void deleteEmpleado(int id) {
        String query = "FROM Empleado where id = :id";
        Empleado dEmpleado = entityManager.createQuery(query, Empleado.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.remove(dEmpleado);
    }


    @Override
    public Empleado getEmpleado(int id) {
        String query = "from Empleado where id = :id";

        return entityManager.createQuery(query, Empleado.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        String query = "FROM Empleado where id = :id";
        Empleado empleadoDB = entityManager.createQuery(query, Empleado.class)
                .setParameter("id", empleado.getId())
                .getSingleResult();
        empleadoDB = empleado.clone();
        entityManager.merge(empleadoDB);

    }
}
