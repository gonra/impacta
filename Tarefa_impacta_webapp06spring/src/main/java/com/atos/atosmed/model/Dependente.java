package com.atos.atosmed.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DEPENDENTE")
public class Dependente extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String vinculo;

	@ManyToOne
	@JoinColumn(name = "cod_titular", referencedColumnName = "id")
	private Titular titular;
	
	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	
}
