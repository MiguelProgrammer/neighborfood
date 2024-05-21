/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItensEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.CategoriaCombo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Itens {

    private Pedido pedido;
    private Long id;
    private Long idPedido;
    private String nome;
    private BigDecimal preco;
    private CategoriaCombo categoria;
    private String descricao;
    private String img;

    public Itens() {
    }

    public Itens(Pedido pedido, Long id, Long idPedido, String nome, BigDecimal preco, CategoriaCombo categoria, String descricao, String img) {
        this.pedido = pedido;
        this.id = id;
        this.idPedido = idPedido;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.descricao = descricao;
        this.img = img;
    }

    public void fromListEntity(Set<Itens> itens) {

        Set<ItensEntity> itensEntities = new HashSet<>();
        itens.forEach(it -> {
            ItensEntity entity = new ItensEntity();
            entity.setId(it.getId());
            entity.setIdPedido(it.getIdPedido());
            entity.setNome(it.getNome());
            entity.setCategoria(it.getCategoria());
            entity.setDescricao(it.getDescricao());
            entity.setPreco(it.getPreco());
            entity.setImg(it.getImg());
            entity.setPedido(it.getPedido().fromEntity(it.getPedido()));
            itensEntities.add(entity);
        });
    }

    public Set<Itens> fromDomain(Set<ItensEntity> itensEntities) {

        Set<Itens> itens = new HashSet<>();
        itensEntities.forEach(it -> {
            Itens item = new Itens();
            item.setId(it.getId());
            item.setIdPedido(it.getIdPedido());
            item.setNome(it.getNome());
            item.setCategoria(it.getCategoria());
            item.setDescricao(it.getDescricao());
            item.setPreco(it.getPreco());
            item.setImg(it.getImg());

            Pedido pedidoDTO = new Pedido();
            pedidoDTO.setId(it.getId());
            pedidoDTO.setIdCliente(it.getPedido().getIdCliente());
            pedidoDTO.setStatus(it.getPedido().getStatus());
            pedidoDTO.setDataPedido(it.getPedido().getDataPedido());
            pedidoDTO.setTotal(it.getPedido().getTotal());
            pedidoDTO.setDataPedidoFim(it.getPedido().getDataPedidoFim());
            item.setPedido(pedido);
            pedidoDTO.setItens(itens);

        });
        return itens;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
