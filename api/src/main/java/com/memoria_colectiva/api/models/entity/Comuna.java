package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ForeignKey;


@Entity
public class Comuna implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="com_id")
    private Long id;

    @Column(name = "com_nombre", length = 20, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_region_comuna"), name = "reg_id", referencedColumnName = "reg_id")
    private Region region;
    
	private static final long serialVersionUID = 3L;
}
