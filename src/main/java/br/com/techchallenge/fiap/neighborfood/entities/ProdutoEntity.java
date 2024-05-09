/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.entities;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
@JsonIgnoreProperties({"idPedido"})
@SequenceGenerator(name = "produto_sequence", initialValue = 1)
public class ProdutoEntity implements Serializable {

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
