package com.apiRestaurante.pe.service;


import com.apiRestaurante.pe.entity.Tipo;

import java.util.List;
import java.util.Optional;

public interface TipoService {

    List<Tipo> findAll();

    Optional<Tipo> findById(long id);

    Tipo add(Tipo tipo);

    Tipo update(Tipo tipo);

    Tipo delete(Tipo tipo);
}
