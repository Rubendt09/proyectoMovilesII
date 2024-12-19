package com.apiRestaurante.pe.rescontroller;

import com.apiRestaurante.pe.entity.Ticket;
import com.apiRestaurante.pe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketRestController {

    @Autowired
    private TicketService servicio;

    @GetMapping
    public List<Ticket> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ticket> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Ticket add(@RequestBody Ticket p) {
        return servicio.add(p);
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Ticket p) {
        p.setIdTck(id);
        Map<String, Object> response = new HashMap<>();
        try {
            Ticket updatedTicket = servicio.update(p);
            response.put("mensaje", "El ticket con ID " + id + " ha sido actualizado exitosamente.");
            response.put("ticket", updatedTicket);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo actualizar el ticket con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Ticket objTicket = servicio.delete(Ticket.builder().idTck(id).build());
            objTicket.setEstado(false); // Marca el ticket como inactivo
            response.put("mensaje", "El ticket con ID " + id + " ha sido eliminado (marcado como inactivo) exitosamente.");
            response.put("ticket", objTicket);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            response.put("mensaje", "No se pudo eliminar el ticket con ID " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
