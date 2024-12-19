package com.apiRestaurante.pe.rescontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.apiRestaurante.pe.entity.Empleado;
import com.apiRestaurante.pe.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<Empleado> findAll() {return servicio.findAll(); }

    @GetMapping("/{id}")
    public Optional <Empleado> findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public Empleado add(@RequestBody Empleado e) { return servicio.add(e); }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Empleado e) {
        e.setIdEmpleado(id);
        Map<String, Object> response = new HashMap<>();
        try {
            Empleado updatedEmpleado = servicio.update(e);
            response.put("mensaje", "El empleado con ID " + id + " ha sido actualizado exitosamente.");
            response.put("empleado", updatedEmpleado);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo actualizar el empleado con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Empleado objEmpleado = servicio.delete(Empleado.builder().idEmpleado(id).build());
            objEmpleado.setEstado(false); // Marca al empleado como inactivo
            response.put("mensaje", "El empleado con ID " + id + " ha sido eliminado (marcado como inactivo) exitosamente.");
            response.put("empleado", objEmpleado);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo eliminar el empleado con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
