package com.memoria_colectiva.api.models.entity;

import java.io.Serializable;

public class Usuario implements Serializable {


    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id;
    private Long com_id;

    private String resto_direccion;
    private String nombres;
    private String apellidos;
    private String correo;

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
}
