package com.apiRestaurante.pe.rescontroller;


import com.apiRestaurante.pe.entity.Tipo;
import com.apiRestaurante.pe.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tipos")
public class TipoRestController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
        Optional<Tipo> tipo = tipoService.findById(id);
        if (tipo.isPresent()) {
            return ResponseEntity.ok(tipo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tipo createTipo(@RequestBody Tipo tipo) {
        return tipoService.add(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTipo(@PathVariable Long id, @RequestBody Tipo tipo) {
        tipo.setIdTipo(id);
        Map<String, Object> response = new HashMap<>();
        try {
            Tipo updatedTipo = tipoService.update(tipo);
            response.put("mensaje", "El tipo con ID " + id + " ha sido actualizado exitosamente.");
            response.put("tipo", updatedTipo);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("mensaje", "No se pudo actualizar el tipo con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteTipo(@PathVariable Long id) {
        Optional<Tipo> tipo = tipoService.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (tipo.isPresent()) {
            tipoService.delete(tipo.get());
            response.put("mensaje", "El tipo con ID " + id + " ha sido eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("mensaje", "El tipo con ID " + id + " no fue encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
