package com.apiRestaurante.pe.rescontroller;

import com.apiRestaurante.pe.entity.Categoria;
import com.apiRestaurante.pe.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.add(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        Map<String, Object> response = new HashMap<>();
        try {
            Categoria updatedCategoria = categoriaService.update(categoria);
            response.put("mensaje", "La categoría con ID " + id + " ha sido actualizada exitosamente.");
            response.put("categoria", updatedCategoria);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("mensaje", "No se pudo actualizar la categoría con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (categoria.isPresent()) {
            categoriaService.delete(categoria.get());
            response.put("mensaje", "La categoría con ID " + id + " ha sido eliminada exitosamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("mensaje", "La categoría con ID " + id + " no fue encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
