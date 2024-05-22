/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Long id;
    private Long idCliente;
    private Set<Produto> produtos = new HashSet<>();
    private BigDecimal total = BigDecimal.ZERO;
    private Status status;
    private Date dataPedido;
    private Date dataPedidoFim;

    public Pedido() {
    }


    public Pedido(Long id, Long idCliente, Set<Produto> produtos, BigDecimal total, Status status, Date dataPedido, Date dataPedidoFim) {
        this.id = id;
        this.idCliente = idCliente;
        this.produtos = produtos;
        this.total = total;
        this.status = status;
        this.dataPedido = dataPedido;
        this.dataPedidoFim = dataPedidoFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPedidoFim() {
        return dataPedidoFim;
    }

    public void setDataPedidoFim(Date dataPedidoFim) {
        this.dataPedidoFim = dataPedidoFim;
    }

    public PedidoEntity domainFromEntity() {
        PedidoEntity entity = new PedidoEntity();
        entity.setIdCliente(this.getIdCliente());
        entity.setStatus(this.getStatus());
        entity.setDataPedido(this.getDataPedido());
        entity.setTotal(this.getTotal());
        entity.setDataPedidoFim(this.getDataPedidoFim());
        entity.setProdutos(this.setProdutosToSetEntity());
        return entity;
    }

    private Set<ProdutoEntity> setProdutosToSetEntity() {
        Set<ProdutoEntity> produtoEntities = new HashSet<>();
        this.produtos.forEach(produto -> {
            produtoEntities.add(produto.dtoFromEntity());
        });
        return produtoEntities;
    }

    public Pedido entityFromDomain(PedidoEntity entity) {
        Pedido domain = new Pedido();
        domain.setIdCliente(entity.getIdCliente());
        domain.setStatus(entity.getStatus());
        domain.setDataPedido(entity.getDataPedido());
        domain.setTotal(entity.getTotal());
        domain.setDataPedidoFim(entity.getDataPedidoFim());
        domain.setProdutos(this.setEntitiesToSetDomain(entity.getProdutos()));
        return domain;
    }

    private Set<Produto> setEntitiesToSetDomain(Set<ProdutoEntity> entities) {
        Set<Produto> produtos = new HashSet<>();
        entities.forEach(produto -> {
            produtos.add(new Produto().entityFromDto(produto));
        });
        return produtos;
    }
}
