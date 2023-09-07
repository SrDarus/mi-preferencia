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
    private Long rol_id;
    @NotEmpty
    @Size(min = 2)
    @Column(unique = true, length = 20)
    private String rol_nombre;

    public Long getRol_id() {
        return rol_id;
    }
    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }


    public String getRol_nombre() {
        return rol_nombre;
    }
    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }


    private static final long serialVersionUID = 5L;



}
