package com.atos.impacta.model;

public class Coordenador extends Funcionario{
  private String loja;
  private Double metaLoja=0.0d;
  
  public Coordenador(){
  }
  
  public String getLoja(){
    return this.loja;
  }
  
  public void setLoja(String value){
    this.loja = value;
  }
  
  public Double getMetaLoja(){
    return this.metaLoja;
  }
  
  public void setMetaLoja(Double value){
    this.metaLoja = value;
  }
  
  @Override
  public Double calculaSalario(Double horas){
	setSalario(40.0f * horas * 0.93f);
	return getSalario();
  }
  
  public String getResumo(){
	return ("Nome: "+getNome()+
	    "\nCPF:"+getCpf()+
		"\nRegional:"+getLoja()+
		"\nMeta:"+getMetaLoja()+
		"\nSalario:"+getSalario()+"\n");
  }
}