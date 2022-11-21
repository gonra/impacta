package com.atos.impacta.model;

public class Gerente extends Funcionario{

  private String regional;
  private Double metaRegional=0.0d;
  
  public Gerente(){
  }

  public String getRegional(){
    return this.regional;
  }
  
  public void setRegional(String value){
    this.regional = value;
  }
  
  public Double getMetaRegional(){
    return this.metaRegional;
  }
  
  public void setMetaRegional(Double value){
    this.metaRegional = value;
  }
  
  @Override
  public Double calculaSalario(Double horas){
	setSalario(60.0f * horas * 0.85f);
	return getSalario();
  }
  
  public String getResumo(){
  return ("Nome: "+getNome()+
    "\nCPF:"+getCpf()+
	"\nRegional:"+getRegional()+
	"\nMeta:"+getMetaRegional()+
	"\nSalario:"+getSalario()+"\n");
  }
}