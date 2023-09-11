package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Pais implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pai_id")
    private Long id;
    
    @NotEmpty
    @Size(min = 2)
    @Column(name = "pai_nombre", unique = true, nullable = false, length = 20)
    private String nombre;

    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "reg_id")
    // @OneToMany(mappedBy = "pais")
    // private List<Region> region;

    private static final long serialVersionUID = 1L;

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
    
}
