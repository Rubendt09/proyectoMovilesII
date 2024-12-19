package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> findAll();

    Optional<Categoria> findById(long id);


    Categoria add(Categoria categoria);

    Categoria update(Categoria categoria);

    Categoria delete(Categoria categoria);
}
