/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.Cliente;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.LoginUseCaseAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class LoginAdapter implements LoginUseCaseAdapterPort {

    private AdmRepository admRepository;
    private ClienteRepository clienteRepository;

    public LoginAdapter(AdmRepository admRepository, ClienteRepository clienteRepository) {
        this.admRepository = admRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente login(Cliente clienteRequest) {
        return new Cliente().fromModel(clienteRepository.findByCpf(clienteRequest.getCpf()));
    }


    @Override
    public Cliente cadastro(Cliente clienteRequest) {
        Cliente cliente = new Cliente();
        ClienteEntity entity = cliente.fromEntity(clienteRequest);
        return new Cliente().fromModel(clienteRepository.save(entity));
    }


    @Override
    public Admin loginAdm(Admin adminRequest) {
        return new Admin().fromModel(admRepository.findByCpf(adminRequest.getCpf()));
    }


    @Override
    public Admin cadastroAdm(Admin adminRequest) {
        return null;
    }
}
