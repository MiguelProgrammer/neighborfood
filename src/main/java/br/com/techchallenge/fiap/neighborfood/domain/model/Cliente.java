/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Set<PedidoDTO> pedidos = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String cpf, Set<PedidoDTO> pedidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.pedidos = pedidos;
    }

    public Cliente fromModel(ClienteEntity entity) {
        Cliente cliente = new Cliente();
        cliente.setNome(entity.getNome());
        cliente.setCpf(entity.getCpf());
        cliente.setEmail(entity.getEmail());
        mapeamento(entity, cliente);
        return cliente;
    }

    public ClienteEntity fromEntity(Cliente clienteRequest) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNome(clienteRequest.getNome());
        entity.setCpf(clienteRequest.getCpf());
        entity.setEmail(clienteRequest.getEmail());
        entity.setPedidos(new HashSet<>());
        return entity;
    }

    private static void mapeamento(ClienteEntity entity, Cliente cliente) {
        Set<PedidoDTO> pedidos = new HashSet<>();
        entity.getPedidos().forEach(pr -> {

            PedidoDTO pedido = new PedidoDTO();
            pedido.setIdCliente(pr.getIdCliente());

            Set<Itens> itens = new HashSet<>();
            pr.getItens().forEach(item -> {

                Itens produtos = new Itens();

                produtos.setIdPedido(item.getIdPedido());
                produtos.setNome(item.getNome());
                produtos.setDescricao(item.getDescricao());
                produtos.setCategoria(item.getCategoria());
                produtos.setPreco(item.getPreco());
                produtos.setPedido(pedido);
                itens.add(produtos);

            });
            pedido.setItens(itens);
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

    public Set<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
}

