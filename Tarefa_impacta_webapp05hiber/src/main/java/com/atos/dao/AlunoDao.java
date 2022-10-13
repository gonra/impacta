package com.atos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.atos.model.*;


public class AlunoDao{
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	public int salvar(Aluno aluno) {
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();
		return aluno.getId();
	}


	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<>();
		TypedQuery<Aluno> consulta = entityManager.createQuery("SELECT p FROM Aluno p", Aluno.class );
		lista = consulta.getResultList();
		return lista;

	}


	public void deletar(Aluno aluno) {
		entityManager.getTransaction().begin();
		entityManager.remove(aluno);
		entityManager.getTransaction().commit();
	}
	
	
}
