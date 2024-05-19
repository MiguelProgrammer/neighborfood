/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain;

import br.com.techchallenge.fiap.neighborfood.domain.model.StatusPedido;

public abstract class AcompanhamentoChain {

    private AcompanhamentoChain StatusPedidoChain;

    public abstract String sms(StatusPedido StatusPedido);
}
