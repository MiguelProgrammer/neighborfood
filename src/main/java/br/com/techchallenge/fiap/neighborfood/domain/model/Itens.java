/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Itens {


    private Set<Produto> produtos = new HashSet<>();

    public Itens() {
    }

    public Itens(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
