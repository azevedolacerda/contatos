package com.home.contatos.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("novoContato")
	public String novoContato() {
		return "novoContato";
	}
	
	@GetMapping("editarContato")
	public String editarContato(@RequestParam("id") Integer id, Model mv) {
		mv.addAttribute("contato", jpaContatoDao.getById(id));
		return "editarContato";
	}
	
	@GetMapping("novoContatoAct")
	public String adicionaContato(Contato contato){
		jpaContatoDao.save(contato);
		return "redirect:/";
	}
	
	@GetMapping("excluirContatoAct")
	public String excluirContato(Integer id) {
		jpaContatoDao.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("editarContatoAct")
	public String editarContatoAct(Contato contato) {
		jpaContatoDao.update(contato);
		return "redirect:/";
	}

}