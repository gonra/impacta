package com.atos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.atos.model.Aluno;
import com.atos.model.Professor;

public class ProfessorDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	public int salvar(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.getTransaction().commit();
		return professor.getId();
	}

	public List<Professor> listar() {
		List<Professor> lista = new ArrayList<>();
		TypedQuery<Professor> consulta = entityManager.createQuery("SELECT p FROM Professor p", Professor.class );
		lista = consulta.getResultList();
		return lista;

	}


	public void deletar(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.remove(professor);
		entityManager.getTransaction().commit();
	}
}
