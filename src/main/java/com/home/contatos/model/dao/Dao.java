package com.home.contatos.model.dao;

import java.util.List;

public interface Dao<T> {
	
	T getById(Integer id);
	void save(T t);
	List<T> getAll();
	void delete(T t);
	void update(T t);
}