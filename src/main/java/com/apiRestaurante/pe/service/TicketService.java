package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    List<Ticket> findAll();

    Optional<Ticket> findById(long id);

    Ticket add(Ticket t);

    Ticket update(Ticket t);

    Ticket delete(Ticket t);
}