package com.apiRestaurante.pe.service.impl;
import com.apiRestaurante.pe.entity.Det_ticket;
import com.apiRestaurante.pe.repository.DetTicketRepository;
import com.apiRestaurante.pe.service.Det_TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetTicketServiceImpl implements Det_TicketService {
    @Autowired
    private DetTicketRepository repositorio;

    @Override
    public List<Det_ticket> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Det_ticket add(Det_ticket dt) {
        return repositorio.save(dt);
    }

    @Override
    public Det_ticket update(Det_ticket dt) {
        return null;
    }

    @Override
    public Det_ticket delete(Det_ticket t) {
        return null;
    }
}