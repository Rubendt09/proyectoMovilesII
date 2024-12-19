package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Det_ticket;
import com.apiRestaurante.pe.entity.Det_TicketPK;
import com.apiRestaurante.pe.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface Det_TicketService {

    List<Det_ticket> findAll();

    Det_ticket add(Det_ticket dt);

    Det_ticket update(Det_ticket dt);

    Det_ticket delete(Det_ticket t);

}
