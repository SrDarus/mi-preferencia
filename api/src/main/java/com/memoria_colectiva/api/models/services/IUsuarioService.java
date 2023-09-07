package com.memoria_colectiva.api.models.services;

import java.util.List;

import com.memoria_colectiva.api.models.entity.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public Usuario findByCorreo(String correo);
}
