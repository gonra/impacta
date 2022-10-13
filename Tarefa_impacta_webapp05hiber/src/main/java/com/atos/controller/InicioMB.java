package com.atos.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "inicio")
@SessionScoped
public class InicioMB {

	public String telaprofessor() {
		return "professor.xhtml";
	}
	
	public String telaaluno() {
		return "aluno.xhtml";
	}
	
	
	
}
