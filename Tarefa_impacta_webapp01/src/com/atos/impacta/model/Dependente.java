package com.atos.impacta.model;

public class Dependente {

    Integer id;
    String nome;
    Integer idade;
    String vinculo;

    Integer cod_funcionario;
    String cod_tipo_funcionario;

    public Dependente() {
    }

    public Dependente(String nome, String vinculo, Integer idade) {
        this.nome = nome;
        this.vinculo = vinculo;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public Integer getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(Integer cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getCod_tipo_funcionario() {
        return cod_tipo_funcionario;
    }

    public void setCod_tipo_funcionario(String cod_tipo_funcionario) {
        this.cod_tipo_funcionario = cod_tipo_funcionario;
    }
}
