///*
// * Copyright (c) 2024. MiguelProgrammer
// */
//
//package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities;
//
//import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "itens_pedido")
//@JsonIgnoreProperties({"idPedido"})
//@SequenceGenerator(name = "itens_sequence", initialValue = 1)
//public class ItensEntity implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
//    private PedidoEntity pedido;
//
//    @Column(name = "pedido_id")
//    private Long idPedido;
//
//    @ManyToOne
//    @Column()
//    private Set<Produto> produtos = new HashSet<>();
//}
