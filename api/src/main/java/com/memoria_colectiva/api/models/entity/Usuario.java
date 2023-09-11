package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.Email;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ForeignKey;


@Entity
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;
    @Column(name = "com_id")
    private Long comId;
    @Column(name = "usu_resto_direccion", length = 50)
    private String restoDireccion;
    @Column(name = "usu_nombres", nullable = false, unique = true, length = 20)
    private String nombres;
    @Column(name = "usu_apellidos", length = 20)
    private String apellidos;
    @Email
    @Column(name = "usu_correo", unique = true, length = 50)
    private String correo;
    @Column(name = "usu_pass", length = 50)
    private String pass;
    /*foreign keys */
    @JoinTable(
        name="usuario_rol", 
        joinColumns= @JoinColumn(name="usu_id"),
    	inverseJoinColumns=@JoinColumn(name="rol_id"),
        uniqueConstraints= {@UniqueConstraint(columnNames= {"usu_id", "rol_id"})},
        foreignKey=@ForeignKey(name = "fk_usu_rol")
        )
    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Rol> roles;

    
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


    public List<Rol> getRoles() {
        return roles;
    }


    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }


    private static final long serialVersionUID = 4L;
}
