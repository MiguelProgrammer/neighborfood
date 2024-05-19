/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.domain.model.Acompanhamento;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoChainRecebidoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    @Override
    public String sms(Acompanhamento acompanhamento) {

        final String MESSAGE = "" +
                "______________________________\n\n" +
                "Pedido 'Recebido'.\n" +
                "Em instantes será concluído. \n\n" +
                "SELECIONE:\n" +
                "1 - Realizar pagamento \n2 - Alterar pedido \n\n" +
                "______________________________\n\n";

        if (acompanhamento.equals(Acompanhamento.RECEBIDO)) {
            return MESSAGE;
        }
        return new AcompanhamentoChainPreparacaoImpl(acompanhamentoChain).sms(acompanhamento);
    }
}
