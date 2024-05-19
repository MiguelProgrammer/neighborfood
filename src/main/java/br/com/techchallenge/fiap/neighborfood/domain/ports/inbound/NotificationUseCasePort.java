/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.Notificacao;

public interface NotificationUseCasePort {

    MimoDTO enviaMimosExecute(MimoDTO mimoRequest);
    Notificacao notificaExecute(MimoDTO mimoRequest);
}
