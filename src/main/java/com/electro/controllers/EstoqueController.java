package com.electro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.electro.entity.Estoque;
import com.electro.repositories.EstoqueRepository;
import com.electro.utils.MapeamentoTelas;


@Controller
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	EstoqueRepository repository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(MapeamentoTelas.LISTA_ESTOQUE.getPath());
		Iterable<Estoque> estoques = repository.findAll();
		modelAndView.addObject("estoques", estoques);
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView form(Estoque estoque) {
		ModelAndView modelAndView = new ModelAndView(MapeamentoTelas.ESTOQUE.getPath());
		modelAndView.addObject("estoque", estoque );
		return modelAndView;
	}
	
	@PostMapping("/salvar")
	public String salvar(Estoque estoque) {
		repository.save(estoque);
		return MapeamentoTelas.ESTOQUE.getPath();
	}
	
	
}
