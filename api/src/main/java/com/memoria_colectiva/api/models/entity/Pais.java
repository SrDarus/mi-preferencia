package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Pais implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pai_id;
    
    @NotEmpty
    @Size(min = 2)
    @Column(unique = true, nullable = false, length = 20)
    private String pai_nombre;

    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "reg_id")
    // @OneToMany(mappedBy = "pais")
    // private List<Region> region;

    public String getPai_nombre() {
        return pai_nombre;
    }

    public void setPai_nombre(String pai_nombre) {
        this.pai_nombre = pai_nombre;
    }

    public Long getPai_id() {
        return pai_id;
    }

    public void setPai_id(Long pai_id) {
        this.pai_id = pai_id;
    }

   
    private static final long serialVersionUID = 1L;
    
}
