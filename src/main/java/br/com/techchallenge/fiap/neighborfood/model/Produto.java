package br.com.techchallenge.fiap.neighborfood.model;

import br.com.techchallenge.fiap.neighborfood.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String nome;
    private BigDecimal preco;
    private Categoria categoria;
    private String descricao;
}
