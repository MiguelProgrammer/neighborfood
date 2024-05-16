/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.service;


import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.core.domain.Acompanhamento;
import br.com.techchallenge.fiap.neighborfood.core.domain.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.core.domain.Pagamento;
import br.com.techchallenge.fiap.neighborfood.core.domain.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    private ModelMapper mapper = new ModelMapper();

    public AcompanhamentoResponse pagamento(Pagamento pagamento) {

        Optional<PedidoEntity> pedid = pedidoRepository.findById(pagamento.getIdPedido());
        AcompanhamentoResponse response = new AcompanhamentoResponse();

        if (pedid.isPresent()) {

            PagamentoEntity entity = mapper.map(pagamento, PagamentoEntity.class);
            pagamentoRepository.save(entity);

            System.out.println("Pagamento Aprovado!");

            try {

                pedid.get().setStatus(Acompanhamento.EM_PREPARACAO);
                pedidoRepository.save(pedid.get());

                response.setStatus(Acompanhamento.EM_PREPARACAO);

                System.out.println(acompanhamentoService.sms(response.getStatus()));

                response.setPedido(mapper.map(pedid, Pedido.class));
                response.setTotal(pedid.get().getTotal());

            } catch (RuntimeException ex) {
                System.err.println("Erro ao realizar pagamento => Pedido não encontrado!!!");
            }
        }
        return response;
    }
}
