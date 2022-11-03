package com.atos.atospessoal.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tbl_pessoa")
public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@SequenceGenerator(name = "pessoaSeq", sequenceName = "pessoa_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "pessoaSeq")
	@Column(name = "id")
	private Long id;
	
	private String nome;
	private Double idade;
	private String profissao;

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
	public Double getIdade() {
		return idade;
	}
	public void setIdade(Double idade) {
		this.idade = idade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
