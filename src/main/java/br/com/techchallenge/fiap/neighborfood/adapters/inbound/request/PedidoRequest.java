/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.request;

import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Itens;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;

public class PedidoRequest {

    private Long id;
    private Long idCliente;
    private Itens<Pro> itens = new Itens();

    public PedidoRequest() {
    }

    public PedidoRequest(Long id, Long idCliente, Itens itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }

    public PedidoRequest dtoFromRequest(PedidoDTO dto) {
        PedidoRequest request = new PedidoRequest();
        request.setIdCliente(dto.getIdCliente());

        dto.getItens().

                request.setItens(dto.getItens());
    }
}
