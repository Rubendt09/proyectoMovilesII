package com.apiRestaurante.pe.rescontroller;

import com.apiRestaurante.pe.entity.Cliente;
import com.apiRestaurante.pe.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService servicio;

    @GetMapping
    public List<Cliente> findAll() {return servicio.findAll(); }

    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public Cliente add(@RequestBody Cliente e) { return servicio.add(e); }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Cliente e) {
        e.setIdCliente(id);
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente updatedCliente = servicio.update(e);
            response.put("mensaje", "El cliente con ID " + id + " ha sido actualizado exitosamente.");
            response.put("cliente", updatedCliente);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo actualizar el cliente con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente objCliente = servicio.delete(Cliente.builder().idCliente(id).build());
            objCliente.setEstado(false); // Marca el cliente como inactivo
            response.put("mensaje", "El cliente con ID " + id + " ha sido eliminado exitosamente.");
            response.put("cliente", objCliente);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo eliminar el cliente con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
