/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.service.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.core.domain.Acompanhamento;
import br.com.techchallenge.fiap.neighborfood.core.usecase.service.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoChainProntoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    @Override
    public String sms(Acompanhamento acompanhamento) {

        final String MESSAGE =
                "______________________________\n\n" +
                        "Pedido está Pronto.\n\n" +
                        "Retire o quanto antes.\n\n" +
                        "______________________________\n\n";

        if (acompanhamento.equals(Acompanhamento.PRONTO)) {
            return MESSAGE;
        }
        return null;
    }
}
