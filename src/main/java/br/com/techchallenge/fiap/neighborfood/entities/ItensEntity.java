/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.entities;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "itens_pedido")
@JsonIgnoreProperties({"idPedido"})
@SequenceGenerator(name = "itens_sequence", initialValue = 1)
public class ItensEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id", insertable=false, updatable=false)
    private PedidoEntity pedido;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pedido_id")
    private Long idPedido;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaCombo categoria;

    @Column(name = "descricao")
    private String descricao;
}
