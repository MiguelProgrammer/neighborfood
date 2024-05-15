package br.com.techchallenge.fiap.neighborfood.core.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItensDTO {

    Collection<ProdutoDTO> produtoList = new ArrayList<>();

}
