/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItemEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Long id;
    private Long idCliente;
    private Set<Item> itemProdutos = new HashSet<>();
    private BigDecimal total = BigDecimal.ZERO;
    private Status status;
    private Date dataPedido;
    private Date dataPedidoFim;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Set<Item> itemProdutos, BigDecimal total, Status status, Date dataPedido, Date dataPedidoFim) {
        this.id = id;
        this.idCliente = idCliente;
        this.itemProdutos = itemProdutos;
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

    public Set<Item> getItemProdutos() {
        return itemProdutos;
    }

    public void setItemProdutos(Set<Item> itemProdutos) {
        this.itemProdutos = itemProdutos;
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
        this.getItemProdutos().forEach(item -> {
            entity.getItensProdutos().add(item.itemDomainFromItemEntity());
        });
        return entity;
    }

    public Pedido entityFromDomain(PedidoEntity entity) {
        Pedido domain = new Pedido();
        domain.setIdCliente(entity.getIdCliente());
        domain.setStatus(entity.getStatus());
        domain.setDataPedido(entity.getDataPedido());
        domain.setTotal(entity.getTotal());
        domain.setDataPedidoFim(entity.getDataPedidoFim());
        entity.getItensProdutos().forEach(item -> {
            domain.getItemProdutos().add(this.itemEntityFromItemDomain(item));
        });
        return domain;
    }

    public Item itemEntityFromItemDomain(ItemEntity itensProdutos) {
        Item item = new Item();
        item.setId(itensProdutos.getId());
        item.setIdPedido(itensProdutos.getIdPedido());
        item.setNome(itensProdutos.getNome());
        item.setCategoria(Categoria.valueOf(itensProdutos.getCategoria().toString()));
        item.setDescricao(itensProdutos.getDescricao());
        item.setPreco(itensProdutos.getPreco());
        item.setImg(itensProdutos.getImg());
        return item;
    }

    public ItemEntity itemDomainFromItemEntity(Item domain) {
        ItemEntity item = new ItemEntity();
        item.setId(domain.getId());
        item.setIdPedido(domain.getIdPedido());
        item.setNome(domain.getNome());
        item.setCategoria(Categoria.valueOf(domain.getCategoria().toString()));
        item.setDescricao(domain.getDescricao());
        item.setPreco(domain.getPreco());
        item.setImg(domain.getImg());
        return item;
    }

    private Set<Produto> setEntitiesToSetDomain(Set<ProdutoEntity> entities) {
        Set<Produto> produtos = new HashSet<>();
        entities.forEach(produto -> {
            produtos.add(new Produto().entityFromDto(produto));
        });
        return produtos;
    }

    private Set<ProdutoEntity> setDomainToSetEntity(Set<Produto> domains) {
        Set<ProdutoEntity> produtos = new HashSet<>();
        domains.forEach(produto -> {
            produtos.add(produto.dtoFromEntity());
        });
        return produtos;
    }
}
