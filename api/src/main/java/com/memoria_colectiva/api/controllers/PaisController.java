package com.memoria_colectiva.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoria_colectiva.api.models.entity.Pais;
import com.memoria_colectiva.api.models.services.IPaisService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RequestMapping("api/pais")
public class PaisController {
    
    @Autowired
    private IPaisService paisService;


    @GetMapping("paises")
    public List<Pais> index() {
        return paisService.findAll();
    }

    @PostMapping("save")
    public ResponseEntity<?> create(@Valid @RequestBody Pais pais, BindingResult result) {
        Pais newPais = null;
        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
            .stream()
            .map(err -> err.getField() +": "+ err.getDefaultMessage())
            .collect(Collectors.toList());

            response.put("Mensaje", "Error al validar datos");
            response.put("Errors", errors);
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.BAD_REQUEST);
        }
        try { 
            newPais =  paisService.save(pais);
            
        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo guardar, intentalo mas tarde");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(newPais.getId(), HttpStatus.CREATED); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Pais newPais = null;
        Map<String, Object> response = new HashMap<>();
        try {
            newPais = paisService.findById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if(newPais == null) {
            response.put("mensaje", "El Pais con id: ".concat(id.toString()).concat(" no existe"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND) ;
        } 
        return new ResponseEntity<Pais>(newPais, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Pais pais, BindingResult result, @PathVariable Long id) {
        
        Pais paisActualizado = null;
        Map<String, Object> response = new HashMap<>();
        
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
            .stream()
            .map(err -> err.getField() +": "+ err.getDefaultMessage())
            .collect(Collectors.toList());

            response.put("Mensaje", "Error al validar datos");
            response.put("Errors", errors);
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.BAD_REQUEST);
        }

        var paisDb = paisService.findById(pais.getId());
 
        if(paisDb == null) {
            response.put("mensaje", "El Pais con id: ".concat(id.toString()).concat(" no existe"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND) ;
        }
        try {
            paisDb.setNombre(pais.getNombre());
            paisActualizado =  paisService.save(paisDb);

            return new ResponseEntity<Pais>(paisActualizado, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar al pais");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            paisService.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar al pais");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

		response.put("mensaje", "Pais eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
