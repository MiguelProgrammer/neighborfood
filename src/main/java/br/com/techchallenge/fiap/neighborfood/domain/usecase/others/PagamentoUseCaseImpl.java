/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;


import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pagamento;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.PagamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;

public class PagamentoUseCaseImpl implements PagamentoUseCasePort {

    private PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;

    @Override
    public AcompanhamentoResponse pagamentoExecute(Pagamento pagamento) {

        Pedido pedidoDTO = pedidoUseCaseAdapterPort.findById(pagamento.getIdPedido());
        AcompanhamentoResponse response = new AcompanhamentoResponse();

        if (pedidoDTO != null) {

            pedidoUseCaseAdapterPort.salvaPagamento(pagamento.fromEntity(pagamento));

            System.out.println("Pagamento Aprovado!");

            try {

                pedidoDTO.setStatus(StatusPedido.EM_PREPARACAO);
                pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.fromEntity(pedidoDTO));

                response.setStatus(StatusPedido.EM_PREPARACAO);

                System.out.println(acompanhamentoUseCasePort.smsExecute(response.getStatus()));

                response.setPedido(pedidoDTO);
                response.setTotal(pedidoDTO.getTotal());

            } catch (RuntimeException ex) {
                System.err.println("Erro ao realizar pagamento => Pedido não encontrado!!!");
            }
        }
        return response;
    }
}
