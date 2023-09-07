package com.memoria_colectiva.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoria_colectiva.api.models.dao.IUsuarioDao;
import com.memoria_colectiva.api.models.entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario save(Usuario usuario){
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioDao.findByCorreo(correo); 
    }

    

}
