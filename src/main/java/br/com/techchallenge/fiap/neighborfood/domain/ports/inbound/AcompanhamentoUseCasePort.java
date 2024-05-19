/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.StatusPedido;

public interface AcompanhamentoUseCasePort {

    AcompanhamentoResponse getOrderStatusExecute(Long idPedido);

    String smsExecute(StatusPedido StatusPedido);

    void fluxoStatusPedidoExecute(Long idPedido, StatusPedido StatusPedido);

    void pedidoStatusExecute(Long idPedido, StatusPedido StatusPedido);
}
