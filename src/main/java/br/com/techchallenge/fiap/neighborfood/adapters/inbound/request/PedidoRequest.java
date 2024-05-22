/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.request;

import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PedidoRequest {

    private Long id;
    private Long idCliente;
    private Set<Produto> produtos = new HashSet<>();

    public PedidoRequest() {
    }

    public PedidoRequest(Long id, Long idCliente, Set<Produto> produtos) {
        this.id = id;
        this.idCliente = idCliente;
        this.produtos = produtos;
    }

    public PedidoRequest dtoFromRequest(PedidoRequestDTO pedidoRequest) {
        PedidoRequest request = new PedidoRequest();
        request.setId(pedidoRequest.getId());
        request.setIdCliente(pedidoRequest.getIdCliente());
        pedidoRequest.getProdutos().forEach(produto -> {
            request.getProdutos().add(this.toDomain(produto));
        });
        return request;
    }

    private Set<Produto> setProdutosDtoFromProdutos(List<ProdutoDTO> produtos) {
        produtos.forEach(produto -> {
            this.getProdutos().add(this.toDomain(produto));
        });
        return this.getProdutos();
    }

    private Produto toDomain(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(Categoria.valueOf(dto.getCategoria().getValue()));
        produto.setImg(dto.getImg());
        produto.setImg(dto.getImg());
        produto.setPreco(dto.getPreco());
        return produto;
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
}
