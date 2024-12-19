package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(long id);

    Producto add(Producto producto);

    Producto update(Producto producto);

    Producto delete(Producto producto);

}
