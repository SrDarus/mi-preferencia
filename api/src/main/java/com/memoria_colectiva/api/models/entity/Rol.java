package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name ="rol_id")
    private Long id;
    @NotEmpty
    @Size(min = 2)
    @Column(name="rol_nombre", unique = true, length = 20)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private static final long serialVersionUID = 5L;



}
