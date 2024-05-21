/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Mimo;
import br.com.techchallenge.fiap.neighborfood.domain.model.Notificacao;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.NotificationUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;

import java.util.Optional;
import java.util.Random;

public class NotificacaoUseCaseImpl implements NotificationUseCasePort {

    private NotificationUseCaseAdapterPort notificacaoAdapterPort;
    private ClienteRepository clienteRepository;

    @Override
    public Mimo enviaMimosExecute(Mimo mimoRequest) {
        Mimo mimo = notificacaoAdapterPort.enviaMimos(mimoRequest);

        Optional<ClienteEntity> cliente = clienteRepository.findById(mimo.getIdUsuario());

        if (cliente.isPresent()) {
            Random gerador = new Random();
            //beneficios.setCodigo(String.valueOf(gerador.nextInt(26)));
            //beneficios.setDesconto(new BigDecimal(10.90).setScale(4, RoundingMode.HALF_UP));
            //beneficios.setIdCliente(cliente.get().getId());

            System.out.println("Mimos enviados para sua próxima compra, obrigado e volte sempre!");
        }
        return null;
    }

    @Override
    public Notificacao notificaExecute(Mimo mimoRequest) {
        return null;
    }
}
