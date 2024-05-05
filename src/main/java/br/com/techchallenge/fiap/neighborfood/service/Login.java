/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.model.Cliente;
import br.com.techchallenge.fiap.neighborfood.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.resources.api.LojaControllerImpl;
import org.apache.catalina.mapper.Mapper;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login {

    @Autowired
    private LojaControllerImpl lojaController;

    @Autowired
    private ClienteRepository clienteRepository;

    private ModelMapper mapper;

    public ClienteRequest login(ClienteRequest clienteRequest){
        try{
            return mapper.map(clienteRepository.findByCpf(clienteRequest.getCpf()), ClienteRequest.class);

        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
