package com.home.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.home.contatos.model.dao.impl.JpaContatoDao;
import com.home.contatos.model.entities.Contato;

@Controller
public class ContatosController {
	
	@Autowired
	private JpaContatoDao jpaContatoDao;
	
	@GetMapping("/")
	public String getTodos(Model mv) {
		List<Contato> listaAll = jpaContatoDao.getAll();
		mv.addAttribute("todosContatos", listaAll);
		return "index";
	}
	
	@GetMapping("addContato")
	public String adicionaContato(Contato contato){
		return "adicionaContato";
	}

}
