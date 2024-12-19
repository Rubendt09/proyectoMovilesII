package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Producto;
import com.apiRestaurante.pe.repository.ProductoRepository;
import com.apiRestaurante.pe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto add(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(producto.getIdProd());
        if (existingProducto.isPresent()) {
            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto not found with id " + producto.getIdProd());
        }
    }

    @Override
    public Producto delete(Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(producto.getIdProd());
        if (existingProducto.isPresent()) {
            productoRepository.delete(producto);
            return producto;
        } else {
            throw new RuntimeException("Producto not found with id " + producto.getIdProd());
        }
    }
}
