package com.atos.atoszoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_ANIMAL")
public class Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	@Id
	@SequenceGenerator(name = "animalSeq", sequenceName = "animal_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "animalSeq")
	@Column(name = "id")
	private Integer id;
	
	private String nome;
	private String especie;
	private String raca;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "cod_jaula", referencedColumnName = "id")
	private Jaula jaula;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Jaula getJaula() {
		return jaula;
	}

	public void setJaula(Jaula jaula) {
		this.jaula = jaula;
	}
	
	

}
