/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import java.math.BigDecimal;

public class AcompanhamentoResponse {
    private PedidoDTO pedido;
    private StatusPedido status;
    private BigDecimal total;

    public AcompanhamentoResponse() {
    }

    public AcompanhamentoResponse(PedidoDTO pedido, StatusPedido status, BigDecimal total) {
        this.pedido = pedido;
        this.status = status;
        this.total = total;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
