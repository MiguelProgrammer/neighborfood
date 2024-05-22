/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoChainProntoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain StatusPedidoChain;

    @Override
    public String sms(Status Status) {

        final String MESSAGE =
                "______________________________\n\n" +
                        "Pedido está Pronto.\n\n" +
                        "Retire o quanto antes.\n\n" +
                        "______________________________\n\n";

        if (Status.equals(Status.PRONTO)) {
            return MESSAGE;
        }
        return null;
    }
}
