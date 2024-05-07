/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.model.ClienteDTO;
import br.com.techchallenge.fiap.neighborfood.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ModelMapper mapper = new ModelMapper();

    public ResponseEntity<Object> login(ClienteRequest clienteRequest) {
        try {
            ClienteEntity cliente = clienteRepository.findByCpf(clienteRequest.getCpf());
            if (ObjectUtils.isEmpty(cliente)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class));
            }

        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public ResponseEntity<Object> cadastro(ClienteRequest clienteRequest) {
        try {

            ClienteEntity cliente = clienteRepository.findByCpf(clienteRequest.getCpf());
            if(ObjectUtils.isEmpty(cliente)) {
                if (ObjectUtils.isEmpty(clienteRequest)) {
                    log.info("CLIENTE NÃO SE IDENTIFICADO.");
                    return ResponseEntity.ok(clienteRepository.save(new ClienteEntity()));
                }
                log.info("CLIENTE CADASTRADO.");
                return ResponseEntity.ok(clienteRepository.save(mapper.map(clienteRequest, ClienteEntity.class)));
            } else {
                return ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class));
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
