/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.response;

import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;

public class AcompanhamentoResponse {
    private Pedido pedido;

    public AcompanhamentoResponse() {
    }

    public AcompanhamentoResponse(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
