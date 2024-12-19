package com.apiRestaurante.pe.rescontroller;


import com.apiRestaurante.pe.entity.Producto;
import com.apiRestaurante.pe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.add(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setIdProd(id); // Asigna el ID al producto antes de actualizar
        Map<String, Object> response = new HashMap<>();
        try {
            Producto updatedProducto = productoService.update(producto);
            response.put("mensaje", "El producto ha sido actualizado exitosamente.");
            response.put("producto", updatedProducto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("mensaje", "No se pudo actualizar el producto con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            productoService.delete(producto.get());
            return ResponseEntity.ok("El producto con ID " + id + " ha sido eliminado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El producto con ID " + id + " no fue encontrado.");
        }
    }



}
