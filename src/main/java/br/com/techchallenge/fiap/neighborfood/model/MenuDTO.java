package br.com.techchallenge.fiap.neighborfood.model;

import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.CategoriaCombo;
import lombok.*;

import java.math.BigDecimal;
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
