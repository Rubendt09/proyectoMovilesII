package com.apiRestaurante.pe.repository;

import com.apiRestaurante.pe.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente ORDER BY id_cliente DESC LIMIT 1", nativeQuery = true)
    Cliente findTopByOrderByIdClienteDesc();

}
