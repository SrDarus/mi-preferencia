package com.memoria_colectiva.api.models.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.memoria_colectiva.api.models.dao.UsuarioRepository;
import com.memoria_colectiva.api.security.SecurityUser;

// @Service
public class SecurityUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(SecurityUserDetailService.class);
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public SecurityUserDetailService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuarioDb = usuarioRepository.findByUsername(username);
        logger.info("///////////////////////"+username);
        if(usuarioDb.isPresent()) {
            return new SecurityUser(usuarioDb.get());
        }
        throw new UsernameNotFoundException("Usuario: "+username+" no encintrado");
    }
}
