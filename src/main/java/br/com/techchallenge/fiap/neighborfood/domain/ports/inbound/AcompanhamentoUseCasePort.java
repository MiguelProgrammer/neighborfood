/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;
import org.springframework.context.annotation.Bean;

public interface AcompanhamentoUseCasePort {

    @Bean
    AcompanhamentoResponse getOrderStatusExecute(Long idPedido);

    @Bean
    String smsExecute(StatusPedido StatusPedido);

    @Bean
    void fluxoStatusPedidoExecute(Long idPedido, StatusPedido StatusPedido);

    @Bean
    void pedidoStatusExecute(Long idPedido, StatusPedido StatusPedido);
}
