/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.domain.model.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoChainRecebidoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain StatusPedidoChain;

    @Override
    public String sms(StatusPedido StatusPedido) {

        final String MESSAGE = "" +
                "______________________________\n\n" +
                "Pedido 'Recebido'.\n" +
                "Em instantes será concluído. \n\n" +
                "SELECIONE:\n" +
                "1 - Realizar pagamento \n2 - Alterar pedido \n\n" +
                "______________________________\n\n";

        if (StatusPedido.equals(StatusPedido.RECEBIDO)) {
            return MESSAGE;
        }
        return new AcompanhamentoChainPreparacaoImpl(StatusPedidoChain).sms(StatusPedido);
    }
}
