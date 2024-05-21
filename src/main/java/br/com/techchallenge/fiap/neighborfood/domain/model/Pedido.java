/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItensEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Long id;
    private Long idCliente;
    private Set<Itens> itens = new HashSet<>();
    private BigDecimal total = BigDecimal.ZERO;
    private StatusPedido status;
    private Date dataPedido;
    private Date dataPedidoFim;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Set<Itens> itens, BigDecimal total, StatusPedido status, Date dataPedido, Date dataPedidoFim) {
        this.id = id;
        this.idCliente = idCliente;
        this.itens = itens;
        this.total = total;
        this.status = status;
        this.dataPedido = dataPedido;
        this.dataPedidoFim = dataPedidoFim;
    }

    public PedidoEntity fromEntity(Pedido pedido) {

        PedidoEntity entity = new PedidoEntity();

        Set<ItensEntity> listaItens = new HashSet<>();
        pedido.getItens().forEach(it -> {

            ItensEntity item = new ItensEntity();
            item.setIdPedido(it.getIdPedido());
            item.setNome(it.getNome());
            item.setDescricao(it.getDescricao());
            item.setPreco(it.getPreco());
            item.setImg(it.getImg());
            item.setCategoria(it.getCategoria());

            PedidoEntity pedidoEntity = new PedidoEntity();
            pedidoEntity.setIdCliente(it.getPedido().getIdCliente());
            pedidoEntity.setStatus(it.getPedido().getStatus());
            pedidoEntity.setDataPedido(it.getPedido().getDataPedido());
            pedidoEntity.setTotal(it.getPedido().getTotal());
            pedidoEntity.setDataPedidoFim(it.getPedido().getDataPedidoFim());
            item.setPedido(pedidoEntity);
            listaItens.add(item);
            pedidoEntity.setItens(listaItens);
        });
        entity.setStatus(pedido.getStatus());
        entity.setIdCliente(pedido.getIdCliente());
        entity.setTotal(pedido.getTotal());
        entity.setItens(listaItens);
        entity.setDataPedido(pedido.getDataPedido());
        entity.setDataPedidoFim(pedido.getDataPedidoFim());

        return entity;
    }

//    public Pedido fromDto(Pedido pedido) {
//        Pedido dto = new Pedido();
//        dto.setId(pedido.getId());
//        pedido.getItens().forEach(item -> {
//            dto.setTotal(dto.getTotal().add(item.getPreco()));
//        });
//        dto.setIdCliente(pedido.getIdCliente());
//        return dto;
//    }
//
//    public Pedido fromDto(Pedido pedido) {
//        Pedido dto = new Pedido();
//        dto.setId(pedido.getId());
//        pedido.getItens().forEach(item -> {
//            dto.se(dto.getTotal().add(item.getPreco()));
//        });
//        dto.setIdCliente(pedido.getIdCliente());
//        return dto;
//    }

    public Pedido fromDomain(PedidoEntity pedidoEntity) {
        Pedido dto = new Pedido();

        Set<Itens> listaItens = new HashSet<>();
        pedidoEntity.getItens().forEach(it -> {

            Itens item = new Itens();
            item.setIdPedido(it.getIdPedido());
            item.setNome(it.getNome());
            item.setDescricao(it.getDescricao());
            item.setPreco(it.getPreco());
            item.setImg(it.getImg());
            item.setCategoria(it.getCategoria());

            Pedido pedido = new Pedido();
            pedido.setIdCliente(it.getPedido().getIdCliente());
            pedido.setStatus(it.getPedido().getStatus());
            pedido.setDataPedido(it.getPedido().getDataPedido());
            pedido.setTotal(it.getPedido().getTotal());
            pedido.setDataPedidoFim(it.getPedido().getDataPedidoFim());

            pedidoEntity.getItens().forEach(itm -> {
                Itens itemPedido = new Itens();
                itemPedido.setId(itm.getId());
                itemPedido.setIdPedido(itm.getIdPedido());
                itemPedido.setNome(itm.getNome());
                itemPedido.setCategoria(itm.getCategoria());
                itemPedido.setDescricao(itm.getDescricao());
                itemPedido.setPreco(itm.getPreco());
                itemPedido.setImg(itm.getImg());
                itemPedido.setPedido(pedido);
                listaItens.add(itemPedido);
            });

            dto.setItens(listaItens);
        });
        dto.setStatus(pedidoEntity.getStatus());
        dto.setIdCliente(pedidoEntity.getIdCliente());
        dto.setTotal(pedidoEntity.getTotal());
        dto.setItens(listaItens);
        dto.setDataPedido(pedidoEntity.getDataPedido());
        dto.setDataPedidoFim(pedidoEntity.getDataPedidoFim());

        return dto;
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

    public Set<Itens> getItens() {
        return itens;
    }

    public void setItens(Set<Itens> itens) {
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

    public Pedido dtoFromDomain(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedido.getId());
        pedido.setItens(pedido.getItens());
        pedido.setTotal(pedido.getTotal());
        pedido.setStatus(pedido.getStatus());
        pedido.setIdCliente(pedido.getIdCliente());
        pedido.setDataPedido(pedido.getDataPedido());
        pedido.setDataPedidoFim(pedido.getDataPedidoFim());
        return pedido;
    }
}
