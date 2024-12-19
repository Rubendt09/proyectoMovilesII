package com.apiRestaurante.pe.repository;

import com.apiRestaurante.pe.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
