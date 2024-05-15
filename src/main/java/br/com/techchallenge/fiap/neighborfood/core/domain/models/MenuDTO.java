package br.com.techchallenge.fiap.neighborfood.core.domain.models;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {

    private CategoriaCombo categoria;
    private List<EstoqueDTO> list;
}
