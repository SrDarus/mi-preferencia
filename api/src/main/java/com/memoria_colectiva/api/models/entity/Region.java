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
    private Long reg_id;

    @Column(unique = true, length = 20)
    private String reg_nombre;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_pais_region"), name = "pai_id", referencedColumnName = "pai_id")
    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "com_id")
    private Pais pais;

    public Long getReg_id() {
        return reg_id;
    }

    public void setReg_id(Long reg_id) {
        this.reg_id = reg_id;
    }


    public String getReg_nombre() {
        return reg_nombre;
    }

    public void setReg_nombre(String reg_nombre) {
        this.reg_nombre = reg_nombre;
    }

    private static final long serialVersionUID = 2L;
}
