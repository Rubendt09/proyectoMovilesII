package com.apiRestaurante.pe.repository;

import com.apiRestaurante.pe.entity.Empleado;
import com.apiRestaurante.pe.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
