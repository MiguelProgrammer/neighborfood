/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;

public interface AcompanhamentoUseCaseAdapterPort {

    AcompanhamentoResponse getOrderStatus(Long idPedido);

    String sms(StatusPedido StatusPedido);

    void fluxoStatusPedido(Long idPedido, StatusPedido StatusPedido);

    void pedidoStatus(Long idPedido, StatusPedido StatusPedido);
}
