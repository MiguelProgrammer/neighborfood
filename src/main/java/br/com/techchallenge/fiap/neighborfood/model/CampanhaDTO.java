package br.com.techchallenge.fiap.neighborfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampanhaDTO {

    private String nome;
    private String descricao;
    private BigDecimal valorDesconto;
}
