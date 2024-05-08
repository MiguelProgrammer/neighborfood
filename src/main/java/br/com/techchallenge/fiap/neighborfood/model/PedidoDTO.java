package br.com.techchallenge.fiap.neighborfood.model;

import br.com.techchallenge.fiap.model.Acompanhamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private Long idCliente;
    private ItensDTO itens;
    private BigDecimal total;
    private Acompanhamento progresso;
}