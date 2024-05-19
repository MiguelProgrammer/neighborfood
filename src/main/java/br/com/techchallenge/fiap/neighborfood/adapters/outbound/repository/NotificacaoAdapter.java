/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.NotificacaoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Notificacao;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoAdapter implements NotificationUseCaseAdapterPort {

    private NotificacaoRepository notificacaoRepository;

    public NotificacaoAdapter(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    @Override
    public MimoDTO enviaMimos(MimoDTO mimoRequest) {
        return new MimoDTO().fromModel(notificacaoRepository.findByIdUsuarioAndAcao(mimoRequest));
    }


    @Override
    public Notificacao notifica(Notificacao notificacao) {
        Notificacao alerta = new Notificacao();
        NotificacaoEntity save = notificacaoRepository.save(alerta.fromEntity(notificacao));
        return alerta.fromDomain(save);
    }
}
