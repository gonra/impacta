package com.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.atos.dao.AlunoDao;
import com.atos.model.Aluno;
import com.atos.model.Endereco;

@ManagedBean(name = "aluno")
@SessionScoped
public class AlunoController {

	private Aluno alunoBean = new Aluno();

	private AlunoDao alunoDao = new AlunoDao();

	public Aluno getAlunoBean() {
		return alunoBean;
	}

	public void setAlunoBean(Aluno alunoBean) {
		this.alunoBean = alunoBean;
	}

	public List<Aluno> getListaAluno() {
		List<Aluno> lista = new ArrayList<>();
		for(Aluno aluno: alunoDao.listar()) {
			lista.add(aluno);
		}
		return lista;
	}

	public String salvar() {
		Integer id = alunoDao.salvar(alunoBean);
		limpar();

		return "";
	}

	public String limpar() {
		alunoBean = new Aluno();
		alunoBean.setEndereco(new Endereco());
		return "";
	}

	public String editar(Aluno aluno) {
		int alunoId = aluno.getId();
		alunoBean = aluno;
		return "";
	}

	public String deletar(Aluno aluno) {
		int alunoId = aluno.getId();
		alunoDao.deletar(aluno);	
		return "";
	}

}
