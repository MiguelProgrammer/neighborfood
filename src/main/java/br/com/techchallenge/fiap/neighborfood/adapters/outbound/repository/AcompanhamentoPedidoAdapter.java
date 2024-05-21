/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.AcompanhamentoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainRecebidoImpl;


public class AcompanhamentoPedidoAdapter extends AcompanhamentoChain
        implements AcompanhamentoUseCaseAdapterPort {

    private PedidoRepository pedidoRepository;
    private AcompanhamentoChain acompanhamentoChain;
    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;

    public AcompanhamentoPedidoAdapter(PedidoRepository pedidoRepository, AcompanhamentoChain acompanhamentoChain, AcompanhamentoUseCasePort acompanhamentoUseCasePort) {
        this.pedidoRepository = pedidoRepository;
        this.acompanhamentoChain = acompanhamentoChain;
        this.acompanhamentoUseCasePort = acompanhamentoUseCasePort;
    }

    @Override
    public AcompanhamentoResponse getOrderStatus(Long idPedido) {
        return acompanhamentoUseCasePort.getOrderStatusExecute(idPedido);
    }


    @Override
    public String sms(StatusPedido StatusPedido) {
        return new AcompanhamentoChainRecebidoImpl(acompanhamentoChain).sms(StatusPedido);
    }


    @Override
    public void fluxoStatusPedido(Long idPedido, StatusPedido StatusPedido) {
        acompanhamentoUseCasePort.pedidoStatusExecute(idPedido, StatusPedido);
    }


    @Override
    public void pedidoStatus(Long idPedido, StatusPedido StatusPedido) {
        acompanhamentoUseCasePort.pedidoStatusExecute(idPedido, StatusPedido);
    }
}
