package com.memoria_colectiva.api.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.memoria_colectiva.api.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

    // public Usuario findByCorreo(String correo);
    

    // @Query("select u from usuario u where u.usu_correo = ?1")
    public Usuario findByCorreo(String correo);


}
