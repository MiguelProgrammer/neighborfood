/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.request;

import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Item;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;

import java.util.HashSet;
import java.util.Set;

public class PedidoRequest {

    private Long id;
    private Long idCliente;
    private Set<Item> itemPedido = new HashSet<>();

    public PedidoRequest() {
    }

    public PedidoRequest(Long id, Long idCliente, Set<Item> itemPedido) {
        this.id = id;
        this.idCliente = idCliente;
        this.itemPedido = itemPedido;
    }

    public PedidoRequest dtoFromRequest(PedidoRequestDTO pedidoRequest) {
        PedidoRequest request = new PedidoRequest();
        request.setId(pedidoRequest.getId());
        request.setIdCliente(pedidoRequest.getIdCliente());
        pedidoRequest.getItensPedido().forEach(item -> {
            Item it = new Item();
            it.setId(item.getId());
            it.setIdPedido(item.getIdPedido());
            it.setNome(item.getNome());
            it.setCategoria(Categoria.valueOf(item.getCategoria().getValue()));
            it.setDescricao(item.getDescricao());
            it.setPreco(item.getPreco());
            it.setImg(item.getImg());
            request.getItemPedido().add(it);
        });
        return request;
    }

    private Set<Produto> setProdutosDtoFromProdutos(Set<ProdutoDTO> produtos) {
        Set<Produto> produtosDomain = new HashSet<>();
        produtos.forEach(produto -> {
            Produto prod = new Produto();
            prod.setId(produto.getId());
            prod.setNome(produto.getNome());
            prod.setCategoria(Categoria.valueOf(produto.getCategoria().getValue()));
            prod.setDescricao(produto.getDescricao());
            prod.setPreco(produto.getPreco());
            prod.setImg(produto.getImg());
            produtosDomain.add(prod);
        });
        return produtosDomain;
    }

    private Produto toDomain(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
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

    public Set<Item> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(Set<Item> itemPedido) {
        this.itemPedido = itemPedido;
    }
}
