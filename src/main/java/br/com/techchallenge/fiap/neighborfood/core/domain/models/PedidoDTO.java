package br.com.techchallenge.fiap.neighborfood.core.domain.models;

import br.com.techchallenge.fiap.neighborfood.core.domain.Acompanhamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private Long idCliente;
    private Acompanhamento progresso;
}