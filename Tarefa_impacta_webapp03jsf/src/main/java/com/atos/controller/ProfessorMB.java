package com.atos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.atos.dao.EnderecoDao;
import com.atos.dao.ProfessorDao;
import com.atos.model.Endereco;
import com.atos.model.Professor;

@ManagedBean(name = "professor")
@SessionScoped
public class ProfessorMB {

	private Professor professorBean;
	
	private ProfessorDao professorDao = new ProfessorDao();
	private EnderecoDao enderecoDao = new EnderecoDao();
	
	
	public Professor getProfessorBean() {
		return professorBean;
	}

	public void setProfessorBean(Professor professorBean) {
		this.professorBean = professorBean;
	}

	public List<Professor> getListaProfessor() {
		List<Professor> lista = new ArrayList<>();
		for(Professor professor: professorDao.listar()) {
			int id = professor.getId();
			Endereco endereco = enderecoDao.carregarEnderecoByIdProfessor(id);
			if(endereco != null) {
				professor.setEndereco(endereco);
			}
			lista.add(professor);
		}
		return lista;
	}

	public String salvar() {
		Integer id = professorDao.salvar(professorBean);
		professorBean.getEndereco().setCodProfessor(id);
		enderecoDao.salvar(professorBean.getEndereco());
		limpar();
		
		return "";
	}
	
	public String limpar() {
		professorBean = new Professor();
		Endereco endereco = new Endereco();
		professorBean.setEndereco(endereco);
		return "";
	}
	
	public String editar(Professor prof) {
		int id = prof.getId();
		professorBean = prof;
		Endereco endereco = enderecoDao.carregarEnderecoByIdProfessor(id);
		if(endereco != null) {
			professorBean.setEndereco(endereco);
		}
		return "";
	}
	
	public String deletar(Professor prof) {
		int id = prof.getId();
		professorDao.deletar(prof);	
		Endereco endereco = enderecoDao.carregarEnderecoByIdProfessor(id);
		if(endereco != null) {
			enderecoDao.deletar(endereco);
		}
		return "";
	}

	@PostConstruct
	public void init() {
		limpar();
	}
	
}
