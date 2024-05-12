/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.model;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private CategoriaCombo categoria;
    private String descricao;
    private String img;
}
