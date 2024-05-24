/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.response;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.request.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.StatusPedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;

import java.math.BigDecimal;

public class AcompanhamentoResponse {

    private PedidoRequest pedidoRequest;
    private Status status;
    private BigDecimal total;

    public AcompanhamentoResponse() {
    }

    public AcompanhamentoResponse(PedidoRequest pedidoRequest, Status status, BigDecimal total) {
        this.pedidoRequest = pedidoRequest;
        this.status = status;
        this.total = total;
    }

    public AcompanhamentoResponseDTO pedidoFromResponse() {
        AcompanhamentoResponseDTO response = new AcompanhamentoResponseDTO();
        response.setPedido(this.pedidoFromResponse().getPedido());
        response.setStatus(StatusPedidoDTO.valueOf(this.getStatus().toString()));
        response.setTotal(this.getTotal());
        return response;
    }

    public AcompanhamentoResponse pedidoEntityFromResponse(PedidoEntity pedidoEntity) {
        AcompanhamentoResponse response = new AcompanhamentoResponse();

        PedidoRequest request = new PedidoRequest();
        request.setIdCliente(pedidoEntity.getIdCliente());
        request.setId(pedidoEntity.getId());

        pedidoEntity.getItensProdutos().forEach(item -> {
            request.getItemPedido().add(new Pedido().itemEntityFromItemDomain(item));
        });
        response.setPedidoRequest(request);
        response.setStatus(pedidoEntity.getStatus());
        response.setTotal(pedidoEntity.getTotal());
        return response;
    }

    public PedidoRequest getPedidoRequest() {
        return pedidoRequest;
    }

    public void setPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
