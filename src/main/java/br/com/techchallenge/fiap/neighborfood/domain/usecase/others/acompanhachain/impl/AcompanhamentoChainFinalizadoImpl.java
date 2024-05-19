/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.domain.model.Acompanhamento;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoChainFinalizadoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    @Override
    public String sms(Acompanhamento acompanhamento) {

        final String MESSAGE =
                "______________________________\n\n" +
                        "Pedido Finalizado.\n\n" +
                        "Como você é nosso cliente especial, em isntantes você receberá uma notficação" +
                        " contendo alguns mimos, obrigado e volte sempre \n\n" +
                        "______________________________\n\n";

        if (acompanhamento.equals(Acompanhamento.FINALIZADO)) {
            return MESSAGE;
        }
        return new AcompanhamentoChainProntoImpl(acompanhamentoChain).sms(acompanhamento);
    }
}
