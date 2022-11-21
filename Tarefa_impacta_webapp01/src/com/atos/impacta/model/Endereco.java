package com.atos.impacta.model;

public class Endereco {
    Integer id;
    String logradouro;
    String cidade;
    String cep;
    String estado;

    public Endereco() {
    }

    public Endereco(String logradouro, String cidade, String cep,String estado) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
