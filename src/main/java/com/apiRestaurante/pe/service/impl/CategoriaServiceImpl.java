package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Categoria;
import com.apiRestaurante.pe.entity.Tipo;
import com.apiRestaurante.pe.repository.CategoriaRepository;
import com.apiRestaurante.pe.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl  implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    @Override
    public Optional<Categoria> findById(long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria add(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findById(categoria.getIdCategoria());
        if (existingCategoria.isPresent()) {
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("Categoria not found with id " + categoria.getIdCategoria());
        }
    }

    @Override
    public Categoria delete(Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findById(categoria.getIdCategoria());
        if (existingCategoria.isPresent()) {
            categoriaRepository.delete(categoria);
            return categoria;
        } else {
            throw new RuntimeException("Categoria not found with id " + categoria.getIdCategoria());
        }
    }

}
