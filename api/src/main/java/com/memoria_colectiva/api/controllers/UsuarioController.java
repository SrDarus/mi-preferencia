package com.memoria_colectiva.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// @CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
// @RequestMapping("api/usuario")
public class UsuarioController {

    private Logger logger = LoggerFactory.getLogger(UsuarioController.class);
  

    @GetMapping("/admin")
    public ResponseEntity<?> getMensajeAdmin() {
  
      var auth =  SecurityContextHolder.getContext().getAuthentication();
      logger.info("Datos del Usuario: {}", auth.getPrincipal());
      logger.info("Datos de los Permisos {}", auth.getAuthorities());
      logger.info("Esta autenticado {}", auth.isAuthenticated());
  
      Map<String, String> mensaje = new HashMap<>();
      mensaje.put("contenido", "Hola Admin");
      return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/public")
    public ResponseEntity<?> getMensajePublico() {
      var auth =  SecurityContextHolder.getContext().getAuthentication();
      logger.info("Datos del Usuario: {}", auth.getPrincipal());
      logger.info("Datos de los Permisos {}", auth.getAuthorities());
      logger.info("Esta autenticado {}", auth.isAuthenticated());
  
      Map<String, String> mensaje = new HashMap<>();
      mensaje.put("contenido", "Hola publico");
      return ResponseEntity.ok(mensaje);
    }
  



}
