/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

public class PagamentoDTO {

    private Long id;
    private Long idPedido;
    private Boolean pagou;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, Long idPedido, Boolean pagou) {
        this.id = id;
        this.idPedido = idPedido;
        this.pagou = pagou;
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

    public Boolean getPagou() {
        return pagou;
    }

    public void setPagou(Boolean pagou) {
        this.pagou = pagou;
    }
}
