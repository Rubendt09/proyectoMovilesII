package com.apiRestaurante.pe.rescontroller;

import com.apiRestaurante.pe.entity.Product;
import com.apiRestaurante.pe.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProRestController {

    @Autowired
    private ProService proService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = proService.findAll();
        return ResponseEntity.ok(products);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Optional<Product> product = proService.findById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Agregar un nuevo producto
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = proService.add(product);
        return ResponseEntity.ok(newProduct);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        if (!proService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        product.setIdProd(id); // Asegurar que el ID coincide
        Product updatedProduct = proService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Eliminar un producto existente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        Optional<Product> product = proService.findById(id);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        proService.delete(product.get());
        return ResponseEntity.noContent().build();
    }
}
