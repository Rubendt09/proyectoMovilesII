package com.apiRestaurante.pe.service.impl;

import com.apiRestaurante.pe.entity.Cliente;
import com.apiRestaurante.pe.repository.ClienteRepository;
import com.apiRestaurante.pe.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

     @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }



    @Override
    public Optional<Cliente> findById(long id) {

        return clienteRepository.findById(id);
    }

    @Override
    public Cliente add(Cliente c) {

        return clienteRepository.save(c);
    }

    @Override
    public Cliente update(Cliente c) {

        Cliente objCl = clienteRepository.getById(c.getIdCliente() );
        BeanUtils.copyProperties(c, objCl);
        return clienteRepository.save( objCl);

    }

    @Override
    public Cliente delete(Cliente c) {

        Cliente objCL = clienteRepository.getById( c.getIdCliente() );
        objCL.setEstado(false);
        return clienteRepository.save( objCL);
    }

    @Override
    public Cliente findLast() {
        return clienteRepository.findTopByOrderByIdClienteDesc();
    }

}
