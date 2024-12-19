package com.apiRestaurante.pe.repository;

import com.apiRestaurante.pe.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
