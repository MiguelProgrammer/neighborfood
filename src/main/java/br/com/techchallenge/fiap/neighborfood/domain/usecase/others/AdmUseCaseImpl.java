/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.UserAdapter;
import br.com.techchallenge.fiap.neighborfood.config.exception.AdminException;
import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.PedidoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AdminUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.AdminUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AdmUseCaseImpl implements AdminUseCasePort {

    private AdminUseCaseAdapterPort adminUseCaseAdapterPort;
    private PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private UserAdapter userAdapter;

    final String MESSAGE = "\n\nAdmin não encontrado ou não localizado!";

    @Override
    public List<AcompanhamentoResponse> listaPedidosExecute(Long idAdmin) {
        List<AcompanhamentoResponse> listaAcomp = new ArrayList<>();

        if (ObjectUtils.isEmpty(userAdapter.adminById(idAdmin))) {
            throw new AdminException(MESSAGE);
        }

        log.info("Listando pedidos ...\n");
        List<PedidoDTO> listaPedidos = new ArrayList<>();
        pedidoUseCaseAdapterPort.pedidosExecute().forEach(pd -> {
            listaPedidos.add(new PedidoDTO().fromDomain(pd));
        });


        listaPedidos.forEach(pr -> {
            log.info("\nPedido: ", pr.getId());
            listaAcomp.add(pedidoUseCaseAdapterPort.pedido(pr));
        });
        log.info("\nListagem finalizada.");

        return listaAcomp;
    }

}
