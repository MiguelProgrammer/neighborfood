/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer;


import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PagamentoService {

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    private ModelMapper mapper = new ModelMapper();

    public AcompanhamentoResponse pagamento(PagamentoDTO pagamento) {

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

                response.setPedido(mapper.map(pedid, PedidoDTO.class));
                response.setTotal(pedid.get().getTotal());

            } catch (RuntimeException ex) {
                System.err.println("Erro ao realizar pagamento => Pedido não encontrado!!!");
            }
        }
        return response;
    }
}
