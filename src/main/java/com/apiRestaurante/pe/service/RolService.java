package com.apiRestaurante.pe.service;

import com.apiRestaurante.pe.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {

    List<Rol> findAll();

    Optional<Rol> findById(long id);

    Rol add(Rol e);

    Rol update(Rol e);

    Rol delete(Rol e);


}