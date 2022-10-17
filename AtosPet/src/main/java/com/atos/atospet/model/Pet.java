package com.atos.atospet.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PET")
public class Pet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@SequenceGenerator(name = "petSeq", sequenceName = "pet_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "petSeq")
	@Column(name = "id")
	private Integer id;
	
	private String nome;
	private String especie;
	private String raca;
	private Integer idade;
	
	@ManyToOne
	@JoinColumn(name = "cod_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "{ id:" + id + 
				", nome:"+ nome +
				", especie:"+ especie +
				", raca:"+ raca +
				", idade:"+ idade +
				"}";
	}
	
}
