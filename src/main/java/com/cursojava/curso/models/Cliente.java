package com.cursojava.curso.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@ToString @EqualsAndHashCode
public class Cliente implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "noafiliado")
    private int noAfiliado;
    @Getter @Setter @Column(name = "RFC")
    private String RFC;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "direccion")
    private String direccion;
    @Getter @Setter @Column(name = "edad")
    private int edad;

    @Override
    public Cliente clone(){
        try{
            return (Cliente) super.clone();
        }
        catch (Exception e){
            System.out.println("Error al clonar");
            return null;
        }
    }
}
