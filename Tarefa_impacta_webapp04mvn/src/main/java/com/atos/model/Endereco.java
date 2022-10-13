package com.atos.model;

public class Endereco {
	
	private Integer id;
	private String rua;
	private String casa;
	private String cidade;
	
	private Integer codAluno=-1;
	private Integer codProfessor=-1;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Integer getCodAluno() {
		return codAluno;
	}
	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}
	
	public Integer getCodProfessor() {
		return codProfessor;
	}
	public void setCodProfessor(Integer codProfessor) {
		this.codProfessor = codProfessor;
	}
	
	@Override
	public String toString() {
		return this.rua + ", " + this.casa + ", " + this.cidade;
	}
	
}
