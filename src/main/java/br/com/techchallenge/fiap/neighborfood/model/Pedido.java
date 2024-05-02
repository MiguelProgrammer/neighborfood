package br.com.techchallenge.fiap.neighborfood.model;

import br.com.techchallenge.fiap.neighborfood.enums.Acompanhamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {


    private Long id;
    private Cliente cliente;
    private Itens itens;
    private Acompanhamento progresso;
}