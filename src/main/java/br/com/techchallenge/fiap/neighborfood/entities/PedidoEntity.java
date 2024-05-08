package br.com.techchallenge.fiap.neighborfood.entities;

import br.com.techchallenge.fiap.model.Acompanhamento;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@SequenceGenerator(name = "pedido_sequence", initialValue = 1)
public class PedidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_cliente")
    private Long idCliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<ProdutoEntity> itens;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    private Acompanhamento acompanhamento;
}
