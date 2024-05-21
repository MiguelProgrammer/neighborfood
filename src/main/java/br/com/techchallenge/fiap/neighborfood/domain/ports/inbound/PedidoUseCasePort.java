/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.Itens;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;

import java.util.Set;

public interface PedidoUseCasePort {

    Object menuOpcionaisExecute();

    AcompanhamentoResponse pedidoExecute(Pedido pedido);

    AcompanhamentoResponse atualizarPedidoExecute(Pedido pedido);

    void removeItensExecute(Set<Itens> itens);
}
