/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.PagamentoDTO;

public interface PagamentoUseCaseAdapterPort {

    AcompanhamentoResponse pagamento(PagamentoDTO pagamento);
}
