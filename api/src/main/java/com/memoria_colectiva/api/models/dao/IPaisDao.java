package com.memoria_colectiva.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.memoria_colectiva.api.models.entity.Pais;

public interface IPaisDao extends CrudRepository<Pais, Long> { 
}
