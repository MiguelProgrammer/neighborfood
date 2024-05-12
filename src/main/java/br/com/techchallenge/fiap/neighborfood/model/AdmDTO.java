package br.com.techchallenge.fiap.neighborfood.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmDTO {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<String> notificacao;
}
