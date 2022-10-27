package com.atos.atoszoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TBL_JAULA")
public class Jaula implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Id
	@SequenceGenerator(name = "jaulaSeq", sequenceName = "jaula_seq", initialValue = 1, allocationSize=1)
	@GeneratedValue(generator = "jaulaSeq")
	@Column(name = "id")
	private Integer id;

	private String nomeZoologico;
	private String bloco;
	private Integer numeroJaula;
	
	@ManyToMany(mappedBy="listaJaulas")
	private List<Cuidador> listaCuidadores = new ArrayList<>();
	
	@OneToMany(mappedBy="jaula", cascade = CascadeType.ALL)
	private List<Animal> listaAnimais = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeZoologico() {
		return nomeZoologico;
	}

	public void setNomeZoologico(String nomeZoologico) {
		this.nomeZoologico = nomeZoologico;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getNumeroJaula() {
		return numeroJaula;
	}

	public void setNumeroJaula(Integer numeroJaula) {
		this.numeroJaula = numeroJaula;
	}

	public List<Cuidador> getListaCuidadores() {
		return listaCuidadores;
	}

	public void setListaCuidadores(List<Cuidador> listaCuidadores) {
		this.listaCuidadores = listaCuidadores;
	}

	public List<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(List<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}
	
	
}
