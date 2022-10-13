package com.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.atos.dao.AlunoDao;
import com.atos.dao.EnderecoDao;
import com.atos.model.Aluno;
import com.atos.model.Endereco;

@ManagedBean(name = "aluno")
@SessionScoped
public class AlunoMB {

	
	private Aluno alunoBean;
	
	private AlunoDao alunoDao = new AlunoDao();
	private EnderecoDao enderecoDao = new EnderecoDao();

	public Aluno getAlunoBean() {
		return alunoBean;
	}

	public void setAlunoBean(Aluno alunoBean) {
		this.alunoBean = alunoBean;
	}

	public List<Aluno> getListaAluno() {
		List<Aluno> lista = new ArrayList<>();
		for(Aluno aluno: alunoDao.listar()) {
			int alunoId = aluno.getId();
			Endereco endereco = enderecoDao.carregarEnderecoByIdAluno(alunoId);
			if(endereco != null) {
				aluno.setEndereco(endereco);
			}
			lista.add(aluno);
		}
		return lista;
	}

	public String salvar() {
		Integer id = alunoDao.salvar(alunoBean);
		alunoBean.getEndereco().setCodAluno(id);
		enderecoDao.salvar(alunoBean.getEndereco());
		limpar();
		
		return "";
	}
	
	public String limpar() {
		alunoBean = new Aluno();
		Endereco endereco = new Endereco();
		alunoBean.setEndereco(endereco);
		
		return "";
	}
	
	public String editar(Aluno aluno) {
		int alunoId = aluno.getId();
		alunoBean = aluno;
		Endereco endereco = enderecoDao.carregarEnderecoByIdAluno(alunoId);
		if(endereco != null) {
			alunoBean.setEndereco(endereco);
		}
		return "";
	}
	
	public String deletar(Aluno aluno) {
		int alunoId = aluno.getId();
		alunoDao.deletar(aluno);	
		Endereco endereco = enderecoDao.carregarEnderecoByIdAluno(alunoId);
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
