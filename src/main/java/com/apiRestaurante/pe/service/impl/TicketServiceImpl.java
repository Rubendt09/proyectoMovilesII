package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Ticket;
import com.apiRestaurante.pe.repository.TicketRepository;
import com.apiRestaurante.pe.service.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository repositorio;

    @Override
    public List<Ticket> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Ticket add(Ticket t) {
        return repositorio.save(t);
    }

    @Override
    public Ticket update(Ticket t) {
        Ticket objTicket = repositorio.getById(t.getIdTck());
        BeanUtils.copyProperties(t, objTicket);
        return repositorio.save(objTicket);
    }

    @Override
    public Ticket delete(Ticket t) {
        Ticket objTicket = repositorio.getById(t.getIdTck());
        objTicket.setEstado(false);
        return repositorio.save(objTicket);
    }

}
