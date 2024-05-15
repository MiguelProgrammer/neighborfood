/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model;

import br.com.techchallenge.fiap.neighborfood.core.domain.CategoriaCombo;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estoque")
@SequenceGenerator(name = "estoque_sequence", initialValue = 1)
public class EstoqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaCombo categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "img")
    private String img;
}
