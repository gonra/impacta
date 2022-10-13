package com.atos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.atos.model.*;


public class EntitiesDao{
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	public int salvarAluno(Aluno aluno) {
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();
		return aluno.getId();
	}

	public List<Aluno> listarAluno() {
		List<Aluno> lista = new ArrayList<>();
		TypedQuery<Aluno> consulta = entityManager.createQuery("SELECT p FROM Aluno p", Aluno.class );
		lista = consulta.getResultList();
		return lista;

	}

	public void deletarAluno(Aluno aluno) {
		entityManager.getTransaction().begin();
		entityManager.remove(aluno);
		entityManager.getTransaction().commit();
	}
	
	public int salvarProfessor(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.getTransaction().commit();
		return professor.getId();
	}

	public List<Professor> listarProfessor() {
		List<Professor> lista = new ArrayList<>();
		TypedQuery<Professor> consulta = entityManager.createQuery("SELECT p FROM Professor p", Professor.class );
		lista = consulta.getResultList();
		return lista;

	}

	public void deletarProfessor(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.remove(professor);
		entityManager.getTransaction().commit();
	}
}
