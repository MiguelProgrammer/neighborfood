/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.request.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Set<Pedido> pedidos = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String cpf, Set<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.pedidos = pedidos;
    }

    public Cliente fromModel(ClienteEntity entity) {
        Cliente cliente = new Cliente();

        if (entity != null) {
            cliente.setId(entity.getId());
            cliente.setNome(entity.getNome());
            cliente.setCpf(entity.getCpf());
            cliente.setEmail(entity.getEmail());
            mapeamento(entity, cliente);
        }
        return cliente;
    }

    public ClienteEntity fromEntity(ClienteRequest clienteRequest) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNome(clienteRequest.getNome());
        entity.setCpf(clienteRequest.getCpf());
        entity.setEmail(clienteRequest.getEmail());
        entity.setPedidos(new HashSet<>());
        return entity;
    }

    private static void mapeamento(ClienteEntity entity, Cliente cliente) {
        Set<Pedido> pedidos = new HashSet<>();
        entity.getPedidos().forEach(itensProdutos -> {

            Pedido pedido = new Pedido().entityFromDomain(itensProdutos);

            pedido.getItemProdutos().forEach(produto -> {
                pedido.getItemProdutos().add(produto);
            });
        });
        cliente.setPedidos(pedidos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}

