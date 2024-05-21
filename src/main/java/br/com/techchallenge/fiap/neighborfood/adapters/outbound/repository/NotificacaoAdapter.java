/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.NotificacaoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Mimo;
import br.com.techchallenge.fiap.neighborfood.domain.model.Notificacao;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificacaoAdapter implements NotificationUseCaseAdapterPort {

    private NotificacaoRepository notificacaoRepository;

    public NotificacaoAdapter(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    @Override
    public Mimo enviaMimos(Mimo mimoRequest) {
        return new Mimo().fromModel(notificacaoRepository.findByIdUsuario(mimoRequest));
    }


    @Override
    public Notificacao notifica(Notificacao notificacao) {
        Notificacao alerta = new Notificacao();
        NotificacaoEntity save = notificacaoRepository.save(alerta.fromEntity(notificacao));
        return alerta.fromDomain(save);
    }


    @Override
    public List<Notificacao> findAll() {
        List<Notificacao> lista = new ArrayList<>();
        notificacaoRepository.findAll().forEach(sms -> {
            lista.add(new Notificacao().fromDomain(sms));
        });
        return lista;
    }
}
