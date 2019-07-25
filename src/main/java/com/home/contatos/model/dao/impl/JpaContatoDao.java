package com.home.contatos.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.contatos.model.dao.Dao;
import com.home.contatos.model.entities.Contato;

@Transactional
@Repository
public class JpaContatoDao implements Dao<Contato>{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Contato t) {
		entityManager.persist(t);
	}

	@Override
	public List<Contato> getAll() {
		String query = "FROM Contato";
		return entityManager.createQuery(query).getResultList();
	}



}
