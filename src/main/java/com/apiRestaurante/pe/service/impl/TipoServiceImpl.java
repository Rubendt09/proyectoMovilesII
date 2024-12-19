package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Tipo;
import com.apiRestaurante.pe.repository.TipoRepository;
import com.apiRestaurante.pe.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    @Override
    public Optional<Tipo> findById(long id) {
        return tipoRepository.findById(id);
    }

    @Override
    public Tipo add(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo update(Tipo tipo) {
        Optional<Tipo> existingTipo = tipoRepository.findById(tipo.getIdTipo());
        if (existingTipo.isPresent()) {
            return tipoRepository.save(tipo);
        } else {
            throw new RuntimeException("Tipo not found with id " + tipo.getIdTipo());
        }
    }

    @Override
    public Tipo delete(Tipo tipo) {
        Optional<Tipo> existingTipo = tipoRepository.findById(tipo.getIdTipo());
        if (existingTipo.isPresent()) {
            tipoRepository.delete(tipo);
            return tipo;
        } else {
            throw new RuntimeException("Tipo not found with id " + tipo.getIdTipo());
        }
    }
}
