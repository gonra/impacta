package com.atos.atosmed.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TITULAR")
public class Titular extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String plano;
	private String profissao;
	private Double salario;
	
	@OneToMany(mappedBy = "titular")
	private List<Dependente> listaDependente = new ArrayList<>();
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public List<Dependente> getListaDependente() {
		return listaDependente;
	}
	public void setListaDependente(List<Dependente> listaDependente) {
		this.listaDependente = listaDependente;
	}
	

	
	
	

}
