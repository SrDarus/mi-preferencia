package com.memoria_colectiva.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoria_colectiva.api.models.entity.Usuario;
import com.memoria_colectiva.api.models.services.IUsuarioService;

// @CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {


    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("usuarios")
    public List<Usuario> index(){
        return usuarioService.findAll();
    }

    
    @GetMapping("by-correo/{correo}")
    public Usuario byCorreo(@PathVariable String correo){
        return usuarioService.findByCorreo(correo);
    }

    @PostMapping("save")
    public Usuario save(Usuario usuario){
        return usuarioService.save(usuario);
    }

}
