/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;

import java.util.Set;

public interface PedidoUseCaseAdapterPort {

    Set<Estoque> menuOpcionais(CategoriaCombo combo);

    AcompanhamentoResponse pedido(PedidoDTO pedido);

    AcompanhamentoResponse atualizarPedido(PedidoDTO pedido);

    PedidoDTO commitUpdates(PedidoEntity pedidoEntity);
    void saveItens(Itens itens);

    void removeItens(Set<Itens> itens);

    Set<Itens> findAllById(Long id);

    Set<Itens> findByIdPedidoItens(Long id);
    PedidoDTO findByIdPedidoPedido(Long id);

    PedidoDTO findById(Long id);

}
