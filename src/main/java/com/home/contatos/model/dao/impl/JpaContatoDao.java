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
	public Contato getById(Integer id) {
		Contato contato  = entityManager.find(Contato.class, id);
		return contato;
	}
	
	@Override
	public void save(Contato t) {
		entityManager.persist(t);
	}

	@Override
	public List<Contato> getAll() {
		String query = "FROM Contato";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void delete(Contato t) {
		entityManager.remove(t);
	}
	
	public void delete(Integer id) {
		delete(this.getById(id));
	}

	@Override
	public void update(Contato t) {
		Contato contato = getById(t.getId());
		contato.setNome(t.getNome());
		contato.setTelefone(t.getTelefone());
		contato.setEmail(t.getEmail());

		entityManager.flush();	
	}
}