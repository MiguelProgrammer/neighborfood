/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.config.exception.PedidoException;
import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.PedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainRecebidoImpl;

import java.util.Date;


public class AcompanhamentoUseCaseImpl implements AcompanhamentoUseCasePort {

    private PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private AcompanhamentoChain StatusPedidoChain;

    public AcompanhamentoUseCaseImpl(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, AcompanhamentoChain statusPedidoChain) {
        this.pedidoUseCaseAdapterPort = pedidoUseCaseAdapterPort;
        StatusPedidoChain = statusPedidoChain;
    }

    @Override
    public AcompanhamentoResponse getOrderStatusExecute(Long idPedido) {

        PedidoDTO pedido = new PedidoDTO();
        try {
            pedido = pedidoUseCaseAdapterPort.findById(idPedido);

            if (pedido.getStatus().equals(StatusPedido.EM_PREPARACAO)) {
                this.pedidoStatusExecute(idPedido, StatusPedido.PRONTO);
                pedido.setStatus(StatusPedido.PRONTO);
            } else if (pedido.getStatus().equals(StatusPedido.PRONTO)) {
                this.fluxoStatusPedidoExecute(idPedido, StatusPedido.FINALIZADO);
                pedido.setStatus(StatusPedido.FINALIZADO);
            }
        } catch (Exception ex) {
            throw new PedidoException("Pedido não encontrado!");
        }

        AcompanhamentoResponse statusPedidoResponse = new AcompanhamentoResponse();
        statusPedidoResponse.setStatus(pedido.getStatus());
        statusPedidoResponse.setTotal(pedido.getTotal());
        statusPedidoResponse.setPedido(pedido);

        return statusPedidoResponse;
    }

    @Override
    public String smsExecute(StatusPedido StatusPedido) {
        return new AcompanhamentoChainRecebidoImpl(StatusPedidoChain).sms(StatusPedido);
    }


    @Override
    public void fluxoStatusPedidoExecute(Long idPedido, StatusPedido StatusPedido) {
        PedidoDTO pedidoDTO = pedidoUseCaseAdapterPort.findById(idPedido);
        pedidoDTO.setStatus(StatusPedido);
        if (pedidoDTO.getStatus().equals(StatusPedido.FINALIZADO)) {
            pedidoDTO.setDataPedidoFim(new Date());
        }
        pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.fromEntity(pedidoDTO));

        System.out.println(this.smsExecute(pedidoDTO.getStatus()));
    }


    @Override
    public void pedidoStatusExecute(Long idPedido, StatusPedido StatusPedido) {
        PedidoDTO pedidoDTO = pedidoUseCaseAdapterPort.findById(idPedido);
        pedidoDTO.setStatus(StatusPedido);
        PedidoDTO pedidoDTO1 = pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.fromEntity(pedidoDTO));
        System.out.println(this.smsExecute(pedidoDTO1.getStatus()));
    }

}
