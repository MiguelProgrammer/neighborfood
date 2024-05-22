/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;

import java.util.HashSet;
import java.util.Set;

public class Estoque {

    private Long id;
    private Set<Produto> produtos = new HashSet<>();

    public Estoque() {
    }

    public Estoque(Long id, Set<Produto> produtos) {
        this.id = id;
        this.produtos = produtos;
    }

    public EstoqueEntity fromEntity(Estoque model) {
        EstoqueEntity entity = new EstoqueEntity();
        Set<ProdutoEntity> produtoEntities = new HashSet<>();
        model.getProdutos().forEach(item -> {
            produtoEntities.add(item.dtoFromEntity());
        });
        entity.setProdutos(produtoEntities);
        return entity;
    }

    public Estoque fromDomain(EstoqueEntity entitie) {
        Estoque estoqueDomain = new Estoque();
        entitie.getProdutos().forEach(item -> {
            Produto produto = new Produto();
            produto.setNome(item.getNome());
            produto.setCategoria(item.getCategoria());
            produto.setDescricao(item.getDescricao());
            produto.setPreco(item.getPreco());
            produto.setImg(item.getImg());
            estoqueDomain.getProdutos().add(produto);
        });
        return estoqueDomain;
    }


    public Set<ProdutoEntity> fromListEntity(Set<Produto> produtos) {
        Set<ProdutoEntity> produtoEntities = new HashSet<>();
        produtos.forEach(produto -> {
            produtoEntities.add(produto.dtoFromEntity());
        });
        return produtoEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
