package com.cursojava.curso.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "empleados")
@ToString @EqualsAndHashCode
public class Empleado implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id")
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "direccion")
    private String direccion;
    @Getter @Setter @Column(name = "edad")
    private int edad;
    @Getter @Setter @Column(name = "numerodeempleado")
    private int numeroDeEmpleado;
    @Getter @Setter @Column(name = "salario")
    private double salario;
    @Getter @Setter @Column(name = "horario")
    private String horario;

    @Override
    public Empleado clone(){
        try{
            return (Empleado) super.clone();
        }
        catch (Exception e){
            System.out.println("Error al clonar");
            return null;
        }
    }

}
