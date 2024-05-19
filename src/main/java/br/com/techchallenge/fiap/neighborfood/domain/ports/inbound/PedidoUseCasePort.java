/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.Itens;
import br.com.techchallenge.fiap.neighborfood.domain.model.PedidoDTO;

import java.util.Set;

public interface PedidoUseCasePort {

    String menuOpcionaisExecute();

    AcompanhamentoResponse pedidoExecute(PedidoDTO pedido);

    AcompanhamentoResponse atualizarPedidoExecute(PedidoDTO pedido);

    void removeItens(Set<Itens> itens);
}
