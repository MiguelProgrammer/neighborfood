/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Estoque {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private CategoriaCombo categoria;
    private String descricao;
    private String img;

    public Estoque() {
    }

    public Estoque(Long id, String nome, BigDecimal preco, CategoriaCombo categoria, String descricao, String img) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
        this.img = img;
    }


    public EstoqueEntity fromEntity(Estoque model) {
        EstoqueEntity entity = new EstoqueEntity();
        entity.setNome(model.getNome());
        entity.setDescricao(model.getDescricao());
        entity.setCategoria(model.getCategoria());
        entity.setPreco(model.getPreco());
        entity.setImg(model.getImg());
        return entity;
    }

    public Set<Estoque> fromDomain(Set<EstoqueEntity> entities) {
        Set<Estoque> listaEstoque = new HashSet<>();
        entities.forEach(est -> {
            Estoque estoque = new Estoque();
            estoque.setNome(est.getNome());
            estoque.setCategoria(est.getCategoria());
            estoque.setDescricao(est.getDescricao());
            estoque.setPreco(est.getPreco());
            estoque.setImg(est.getImg());
            estoque.setId(est.getId());

            listaEstoque.add(estoque);
        });

        return listaEstoque;
    }


    public Set<EstoqueEntity> fromListEntity(Set<Estoque> lista) {
        Set<EstoqueEntity> listaEstoque = new HashSet<>();
        listaEstoque.forEach(est -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setNome(est.getNome());
            estoque.setCategoria(est.getCategoria());
            estoque.setDescricao(est.getDescricao());
            estoque.setPreco(est.getPreco());
            estoque.setImg(est.getImg());
            estoque.setId(est.getId());

            listaEstoque.add(estoque);
        });

        return listaEstoque;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
