package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAll();

    Optional<Empleado> findById(long id);

    Empleado add(Empleado e);

    Empleado update(Empleado e);

    Empleado delete(Empleado e);

}
