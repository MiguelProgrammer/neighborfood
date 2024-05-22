/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities;

import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@JsonIgnoreProperties({"idPedido"})
public class PedidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoEntity> produtos = new HashSet<>();

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "data_pedido")
    private Date dataPedido;

    @Column(name = "data_pedido_fim")
    private Date dataPedidoFim;
}
