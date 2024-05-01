package br.com.techchallenge.fiap.neighborfood.entities;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_sequence", initialValue = 1)
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<PedidoEntity> pedidos = new HashSet<>();
}
