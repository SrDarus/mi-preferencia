package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;

import jakarta.validation.constraints.Email;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;
    @Column(name = "com_id")
    private Long comId;
    @Column(name = "cli_resto_direccion", length = 50)
    private String restoDireccion;
    @Column(name = "cli_nombres", nullable = false, unique = true, length = 20)
    private String nombres;
    @Column(name = "cli_apellidos", length = 20)
    private String apellidos;
    @Email
    @Column(name = "cli_correo", unique = true, length = 50)
    private String correo;
    @Column(name = "cli_pass", length = 50)
    private String pass;
    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public Long getComId() {
        return comId;
    }


    public void setComId(Long comId) {
        this.comId = comId;
    }


    public String getRestoDireccion() {
        return restoDireccion;
    }


    public void setRestoDireccion(String restoDireccion) {
        this.restoDireccion = restoDireccion;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public String getPass() {
        return pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }

    private static final long serialVersionUID = 4L;
}
