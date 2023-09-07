package com.memoria_colectiva.api.models.services;

import java.util.List;

import com.memoria_colectiva.api.models.entity.Pais;

public interface IPaisService {
    public List<Pais> findAll();
    public Pais findById(Long id);
    public Pais save(Pais pais);
    public void deleteById(Long id);
}
