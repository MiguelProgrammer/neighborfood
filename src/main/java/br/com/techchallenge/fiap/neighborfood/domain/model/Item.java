/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItemEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;

import java.math.BigDecimal;

public class Item {

    private Long id;
    private Long idPedido;
    private String nome;
    private BigDecimal preco;
    private Categoria categoria;
    private String descricao;
    private String img;

    public Item() {
    }

    public Item(Long id, Long idPedido, String nome, BigDecimal preco, Categoria categoria, String descricao, String img) {
        this.id = id;
        this.idPedido = idPedido;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
        this.img = img;
    }

    public ItemEntity itemDomainFromItemEntity() {
        ItemEntity entity = new ItemEntity();
        entity.setId(this.id);
        entity.setIdPedido(this.idPedido);
        entity.setNome(this.nome);
        entity.setCategoria(this.categoria);
        entity.setDescricao(this.descricao);
        entity.setPreco(this.preco);
        entity.setImg(this.img);

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
