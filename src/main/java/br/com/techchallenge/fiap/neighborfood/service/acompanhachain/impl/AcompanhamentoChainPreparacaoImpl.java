/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service.acompanhachain.impl;

import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.neighborfood.service.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoChainPreparacaoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain acompanhamentoChain;

    @Override
    public String sms(Acompanhamento acompanhamento) {

        final String MESSAGE =
                "______________________________\n\n" +
                "Pedido Em preparação.\n\n" +
                "Em instantes será concluído. \n\n" +
                "Somente aguarde, obrigado.\n\n" +
                "______________________________\n\n";

        if(acompanhamento.equals(Acompanhamento.EM_PREPARACAO)){
            return MESSAGE;
        }
        return new AcompanhamentoChainFinalizadoImpl(acompanhamentoChain).sms(acompanhamento);
    }
}
