package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Empleado;
import com.apiRestaurante.pe.repository.EmpleadoRepository;
import com.apiRestaurante.pe.service.EmpleadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {


    @Autowired
    private EmpleadoRepository repositorio;

    @Override
    public List<Empleado> findAll() { return repositorio.findAll(); }

    @Override
    public Optional<Empleado> findById(long id) { return  repositorio.findById(id); }

    @Override
    public Empleado add (Empleado e) { return  repositorio.save(e); }

    @Override
    public Empleado update(Empleado e){
        Empleado objempleado = repositorio.getById(e.getIdEmpleado());
        BeanUtils.copyProperties(e, objempleado);
        return repositorio.save(objempleado);
    }

    @Override
    public Empleado delete(Empleado e){
        Empleado objempleado = repositorio.getById(e.getIdEmpleado());
        objempleado.setEstado(false);
        return  repositorio.save(objempleado);
    }
}
