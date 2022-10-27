package com.atos.atoszoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CUIDADOR")
public class Cuidador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "cuidadorSeq", sequenceName = "cuidador_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "cuidadorSeq")
	@Column(name = "id")
	private Integer id;

	private String matricula;
	private String nome;
	
	@ManyToMany
	private List<Jaula> listaJaulas = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jaula> getListaJaulas() {
		return listaJaulas;
	}

	public void setListaJaulas(List<Jaula> listaJaulas) {
		this.listaJaulas = listaJaulas;
	}
	
	
	
}
