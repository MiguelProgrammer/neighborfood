/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.request;

import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Itens;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.CategoriaCombo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PedidoRequest {

    private Long id;
    private Long idCliente;
    private List<Produto> itens;

    public PedidoRequest() {
    }

    public PedidoRequest(Long id, Long idCliente, List<Produto> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.itens = itens;
    }

    public PedidoRequest PedidoRequest(PedidoDTO dto) {
        PedidoRequest pedidoRequest = new PedidoRequest();
        pedidoRequest.setId(dto.getId());
        pedidoRequest.setIdCliente(dto.getIdCliente());

        Set<Produto> produtos = new HashSet<>();
        dto.getItens().forEach(it -> {
            Produto itens1 = new Produto();
            itens1.setNome(it.getNome());
            itens1.setPreco(it.getPreco());
            itens1.setDescricao(it.getDescricao());
            itens1.setCategoria(CategoriaCombo.valueOf(it.getCategoria().getValue()));
            produtos.add(itens1);
        });
        pedidoRequest.setItens(produtos.stream().toList());
        return pedidoRequest;
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

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }
}
