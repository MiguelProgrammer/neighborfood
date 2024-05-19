/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;

import java.math.BigDecimal;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private CategoriaCombo categoria;
    private String descricao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, BigDecimal preco, CategoriaCombo categoria, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public ProdutoDTO(Long id, String nome, BigDecimal preco, CategoriaCombo categoria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public ProdutoDTO fromEntity(ProdutoEntity entity) {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setCategoria(entity.getCategoria());
        produto.setNome(entity.getNome());
        produto.setDescricao(entity.getDescricao());
        produto.setPreco(entity.getPreco());
        return produto;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public CategoriaCombo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCombo categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
