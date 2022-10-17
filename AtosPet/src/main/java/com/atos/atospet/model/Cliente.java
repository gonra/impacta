package com.atos.atospet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CLIENTE")
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "clienteSeq", sequenceName = "cliente_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "clienteSeq")
	@Column(name = "id")
	private Integer id;
	private String nome;
	private String cpf;
	private Integer idade;
	
	@OneToOne(mappedBy="cliente", cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Pet> listaPet = new ArrayList<>();

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pet> getListaPet() {
		return listaPet;
	}

	public void setListaPet(List<Pet> listaPet) {
		this.listaPet = listaPet;
	}
	
	@Override
	public String toString() {
		return "{ id:" + id 
				+", nome:"+nome
				+", cpf:"+cpf
				+", idade:"+idade
				+", endereco: " + endereco.toString() 
				+", listaPet: " + listaPet.size()
				+"}";
	}
}
