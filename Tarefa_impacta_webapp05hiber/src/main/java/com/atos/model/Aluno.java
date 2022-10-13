package com.atos.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ALUNO")
public class Aluno extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String turma;
	private Double media;
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	
	
}
