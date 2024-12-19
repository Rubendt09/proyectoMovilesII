package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Product;
import com.apiRestaurante.pe.repository.ProRepository;
import com.apiRestaurante.pe.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    private ProRepository productRepository;

    @Override
    public List<Product> findAll() {
        // Retorna todos los productos
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        // Retorna un producto por su ID, si existe
        return productRepository.findById(id);
    }

    @Override
    public Product add(Product product) {
        // Guarda un nuevo producto en la base de datos
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        // Actualiza un producto existente
        if (productRepository.existsById(product.getIdProd())) {
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + product.getIdProd());
        }
    }

    @Override
    public Product delete(Product product) {
        // Elimina un producto existente
        if (productRepository.existsById(product.getIdProd())) {
            productRepository.delete(product);
            return product;
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + product.getIdProd());
        }
    }
}
