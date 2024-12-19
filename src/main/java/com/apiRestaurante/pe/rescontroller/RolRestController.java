package com.apiRestaurante.pe.rescontroller;

import com.apiRestaurante.pe.entity.Rol;
import com.apiRestaurante.pe.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolRestController {

    @Autowired
    private RolService servicio;

    @GetMapping
    public List<Rol> findAll() {return servicio.findAll(); }

    @GetMapping("/{id}")
    public Optional<Rol> findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public Rol add(@RequestBody Rol r) { return servicio.add(r); }

    @PutMapping("{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol r) {
        r.setIdRol(id);
        return servicio.update(r);
    }

    @DeleteMapping("{id}")
    public Rol delete(@PathVariable Long id) {
        Rol objrol = new Rol();
        objrol.setEstado(false);
        return servicio.delete(Rol.builder().idRol(id).build());
    }
}