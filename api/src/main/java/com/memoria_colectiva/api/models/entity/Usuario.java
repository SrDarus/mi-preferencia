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
    private Long usu_id;
    private Long com_id;
    @Column(length = 50)
    private String resto_direccion;
    @Column(nullable = false, unique = true, length = 20)
    private String nombres;
    @Column(length = 20)
    private String apellidos;
    @Email
    @Column(unique = true, length = 50)
    private String correo;
    @Column(length = 50)
    private String password;
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

    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public Long getUsu_id() {
        return usu_id;
    }
    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }
    public Long getCom_id() {
        return com_id;
    }
    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }
    public String getResto_direccion() {
        return resto_direccion;
    }
    public void setResto_direccion(String resto_direccion) {
        this.resto_direccion = resto_direccion;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	private static final long serialVersionUID = 4L;
}
