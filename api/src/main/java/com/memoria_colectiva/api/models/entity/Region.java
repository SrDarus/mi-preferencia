package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Region implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reg_id")
    private Long id;
    @Column(name = "reg_nombre", unique = true, length = 20)
    private String nombre;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_pais_region"), name = "pai_id", referencedColumnName = "pai_id")
    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "com_id")
    private Pais pais;

    
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    private static final long serialVersionUID = 2L;
}
