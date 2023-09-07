package com.memoria_colectiva.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.memoria_colectiva.api.models.entity.Pais;
import com.memoria_colectiva.api.models.entity.Usuario;

public interface IPaisDao extends CrudRepository<Pais, Long> { 
}
