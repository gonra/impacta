package com.atos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.atos.dao.ProfessorDao;
import com.atos.model.Endereco;
import com.atos.model.Professor;

@ManagedBean(name = "professor")
@SessionScoped
public class ProfessorController {

	private Professor professorBean = new Professor();
	
	private ProfessorDao professorDao = new ProfessorDao();
	
	
	public Professor getProfessorBean() {
		return professorBean;
	}

	public void setProfessorBean(Professor professorBean) {
		this.professorBean = professorBean;
	}

	public List<Professor> getListaProfessor() {
		List<Professor> lista = new ArrayList<>();
		for(Professor professor: professorDao.listar()) {
			lista.add(professor);
		}
		return lista;
	}

	public String salvar() {
		Integer id = professorDao.salvar(professorBean);
		limpar();
		
		return "";
	}
	
	public String limpar() {
		professorBean = new Professor();
		professorBean.setEndereco(new Endereco());
		return "";
	}
	
	public String editar(Professor prof) {
		int id = prof.getId();
		professorBean = prof;
		return "";
	}
	
	public String deletar(Professor prof) {
		int id = prof.getId();
		professorDao.deletar(prof);	

		return "";
	}

	
}
