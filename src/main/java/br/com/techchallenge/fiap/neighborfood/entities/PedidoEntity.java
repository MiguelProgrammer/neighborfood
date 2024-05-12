package br.com.techchallenge.fiap.neighborfood.entities;

import br.com.techchallenge.fiap.model.Acompanhamento;
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
@Builder
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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItensEntity> itens = new HashSet<>();

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Acompanhamento status;

    @Column(name = "data_pedido")
    private Date dataPedido;

    @Column(name = "data_pedido_fim")
    private Date dataPedidoFim;
}
