package com.atos.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROFESSOR")
public class Professor extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String disciplina;
	private Double salario;
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
}
