/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl;

import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoChainPreparacaoImpl extends AcompanhamentoChain {

    private AcompanhamentoChain StatusPedidoChain;

    @Override
    public String sms(StatusPedido StatusPedido) {

        final String MESSAGE =
                "______________________________\n\n" +
                        "Pedido Em preparação.\n\n" +
                        "Em instantes será concluído. \n\n" +
                        "Somente aguarde, obrigado.\n\n" +
                        "______________________________\n\n";

        if (StatusPedido.equals(StatusPedido.EM_PREPARACAO)) {
            return MESSAGE;
        }
        return new AcompanhamentoChainFinalizadoImpl(StatusPedidoChain).sms(StatusPedido);
    }
}
