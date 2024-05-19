/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAdapter {

    private AdmRepository admRepository;
    private ClienteRepository clienteRepository;

    public UserAdapter(AdmRepository admRepository, ClienteRepository clienteRepository) {
        this.admRepository = admRepository;
        this.clienteRepository = clienteRepository;
    }


    public Cliente clienteById(Long idCliente) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(idCliente);
        return new Cliente().fromModel(cliente.get());
    }

    public Cliente clienteByCpf(String cpf) {
        return new Cliente().fromModel(clienteRepository.findByCpf(cpf));
    }

    public Admin adminByCpf(String cpf) {
        return new Admin().fromModel(admRepository.findByCpf(cpf));
    }

    public Admin adminById(Long idAdmin) {
        Optional<AdminEntity> adminByAdmin = admRepository.findById(idAdmin);
        return new Admin().fromModel(adminByAdmin.get());
    }

}
