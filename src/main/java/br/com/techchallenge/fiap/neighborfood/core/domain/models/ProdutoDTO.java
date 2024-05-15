package br.com.techchallenge.fiap.neighborfood.core.domain.models;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String nome;
    private BigDecimal preco;
    private CategoriaCombo categoria;
    private String descricao;
    private String img;
}
