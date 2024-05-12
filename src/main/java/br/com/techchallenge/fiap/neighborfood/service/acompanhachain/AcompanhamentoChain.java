/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service.acompanhachain;

import br.com.techchallenge.fiap.model.Acompanhamento;

public abstract class AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    public abstract String sms(Acompanhamento acompanhamento);
}
