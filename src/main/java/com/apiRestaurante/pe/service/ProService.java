package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProService {

    List<Product> findAll();
    Optional<Product> findById(long id);

    Product add(Product product);

    Product update(Product product);

    Product delete(Product product);
}
