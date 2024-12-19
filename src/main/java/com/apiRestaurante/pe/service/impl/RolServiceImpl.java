package com.apiRestaurante.pe.service.impl;


import com.apiRestaurante.pe.entity.Rol;
import com.apiRestaurante.pe.repository.RolRepository;
import com.apiRestaurante.pe.service.RolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repositorio;

    @Override
    public List<Rol> findAll() { return repositorio.findAll(); }

    @Override
    public Optional<Rol> findById(long id) { return  repositorio.findById(id); }

    @Override
    public Rol add (Rol r) { return  repositorio.save(r); }

    @Override
    public Rol update(Rol r){
        Rol objrol = repositorio.getById(r.getIdRol());
        BeanUtils.copyProperties(r, objrol);
        return repositorio.save(objrol);
    }

    @Override
    public Rol delete(Rol r){
        Rol objrol = repositorio.getById(r.getIdRol());
        objrol.setEstado(false);
        return  repositorio.save(objrol);
    }

}
