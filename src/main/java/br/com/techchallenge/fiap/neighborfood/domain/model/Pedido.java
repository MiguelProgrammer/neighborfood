/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItensEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Long id;
    private Long idCliente;
    private Itens itens = new Itens();
    private BigDecimal total = BigDecimal.ZERO;
    private StatusPedido status;
    private Date dataPedido;
    private Date dataPedidoFim;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Itens itens, BigDecimal total, StatusPedido status, Date dataPedido, Date dataPedidoFim) {
        this.id = id;
        this.idCliente = idCliente;
        this.itens = itens;
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

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
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

    public PedidoEntity fromEntity(Pedido domain) {
        PedidoEntity entity = new PedidoEntity();
        entity.setIdCliente(domain.getIdCliente());
        entity.setStatus(domain.getStatus());
        entity.setTotal(domain.getTotal());
        entity.setDataPedido(domain.getDataPedido());

        Set<ProdutoEntity> produtoEntity = new HashSet<>();
        domain.getItens().getProdutos().forEach(item -> {
            ProdutoEntity produto = new ProdutoEntity();
            produto.setNome(item.getNome());
            produto.setDescricao(item.getDescricao());
            produto.setPreco(item.getPreco());
            produto.setCategoria(item.getCategoria());
            produtoEntity.add(produto);
        });
        entity.setItens(produtoEntity);
        entity.setDataPedidoFim(domain.getDataPedidoFim());
        return entity;
    }
}
