package com.cursojava.curso.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

    @JsonProperty
    private String nombre;
    @JsonProperty
    private int edad;
}
