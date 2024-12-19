package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(long id);

    Cliente add(Cliente c);

    Cliente update(Cliente c);

    Cliente delete(Cliente c);

    Cliente findLast();


}
