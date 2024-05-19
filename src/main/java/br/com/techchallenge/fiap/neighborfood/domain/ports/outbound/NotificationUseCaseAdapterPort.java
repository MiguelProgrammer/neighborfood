/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Notificacao;

public interface NotificationUseCaseAdapterPort {

    MimoDTO enviaMimos(MimoDTO mimoRequest);
    Notificacao notifica(Notificacao notificacao);

}
