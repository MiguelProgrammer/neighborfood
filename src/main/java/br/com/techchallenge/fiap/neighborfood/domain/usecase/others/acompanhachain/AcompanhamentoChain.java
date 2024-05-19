/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain;

import br.com.techchallenge.fiap.neighborfood.domain.model.Acompanhamento;

public abstract class AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    public abstract String sms(Acompanhamento acompanhamento);
}
