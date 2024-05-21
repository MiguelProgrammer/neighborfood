/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.domain.dto.*;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AcompanhamentoResponse {
    private Pedido pedido;
    private StatusPedido status;
    private BigDecimal total;

    public AcompanhamentoResponse() {
    }

    public AcompanhamentoResponse(Pedido pedido, StatusPedido status, BigDecimal total) {
        this.pedido = pedido;
        this.status = status;
        this.total = total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public AcompanhamentoResponseDTO domainFromDto(AcompanhamentoResponse domain) {
        AcompanhamentoResponseDTO dto = new AcompanhamentoResponseDTO();
        dto.setStatus(AcompanhamentoDTO.fromValue(domain.getStatus().toString()));
        dto.setTotal(domain.getTotal());

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(domain.getPedido().getId());
        pedidoDTO.setIdCliente(domain.getPedido().getIdCliente());

        Set<ProdutoDTO> listaProdutoDto = new HashSet<>();
        domain.getPedido().getItens().forEach(pr -> {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome(pr.getNome());
            produtoDTO.setPreco(pr.getPreco());
            produtoDTO.setCategoria(CategoriaComboDTO.valueOf(pr.getCategoria().toString()));
            produtoDTO.setDescricao(pr.getDescricao());
            produtoDTO.setImg(pr.getImg());
            listaProdutoDto.add(produtoDTO);
        });

        pedidoDTO.setItens(listaProdutoDto.stream().toList());
        dto.setPedido(pedidoDTO);
        return dto;
    }

}
