package com.atos.impacta.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario{
  private Integer id;
  private String nome;
  private String cpf;
  private Double salario;

  private Endereco endereco = new Endereco();
  private List<Dependente> dependenteList = new ArrayList<>();

  public Funcionario(){
  }

  public Integer getId(){
    return this.id;
  }

  public void setId(Integer value){
    this.id = value;
  }

  public String getCpf(){
	return this.cpf;
  }
  
  public void setCpf(String value){
    this.cpf=value;
  }
  
  public String getNome(){
	return this.nome;
  }
  
  public void setNome(String value){
    this.nome=value;
  }

  public Double calculaSalario(Double horas){
    return (50*horas);
  }

  public Double getSalario(){
    return salario;
  }
  
  public void setSalario(Double value){
    this.salario = value;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Dependente> getDependenteList() {
    return dependenteList;
  }

  public void setDependenteList(List<Dependente> dependenteList) {
    this.dependenteList = dependenteList;
  }

}