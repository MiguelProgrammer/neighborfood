/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.model;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;

public class Admin {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String notificacao;

    public Admin() {
    }

    public Admin(Long id, String nome, String email, String cpf, String notificacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.notificacao = notificacao;
    }

    public Admin fromModel(AdminEntity entity) {
        Admin ad = new Admin();
        ad.setNome(entity.getNome());
        ad.setCpf(entity.getCpf());
        ad.setEmail(entity.getEmail());
        ad.setNotificacao(entity.getNotificacao());
        return ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

}
