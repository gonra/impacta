package com.atos.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioMB {

	public String telaprofessor() {
		return "professor.xhtml";
	}
	
	public String telaaluno() {
		return "aluno.xhtml";
	}
}
