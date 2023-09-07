package com.memoria_colectiva.api.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoria_colectiva.api.models.dao.IPaisDao;
import com.memoria_colectiva.api.models.entity.Pais;

@Service
public class PaisServiceImp implements IPaisService {

    @Autowired
    private IPaisDao paisDao;

    @Override
    public List<Pais> findAll() {
        return (List<Pais>) paisDao.findAll();
    }

    @Override
    public Pais save(Pais pais) {
        Pais newPais = paisDao.save(pais);
        return newPais;
    }

    @Override
    public Pais findById(Long id) {
        return paisDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        paisDao.deleteById(id);
    }

    
    
}
