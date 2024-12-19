package com.apiRestaurante.pe.rescontroller;


import com.apiRestaurante.pe.entity.Det_ticket;
import com.apiRestaurante.pe.entity.Det_TicketPK;
import com.apiRestaurante.pe.entity.Ticket;
import com.apiRestaurante.pe.service.Det_TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/detTicket")
public class DetTicketRestController {

    @Autowired
    private Det_TicketService servicio;

    @GetMapping
    public List<Det_ticket> findAll() {
        return servicio.findAll();
    }

    @PostMapping
    public Det_ticket add(@RequestBody Det_ticket dt) {
        return servicio.add(dt);
    }


}

