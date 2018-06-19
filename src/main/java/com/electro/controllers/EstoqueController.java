package com.electro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.electro.entity.Estoque;
import com.electro.repositories.EstoqueRepository;
import com.electro.utils.MapeamentoTelas;

@Controller
public class EstoqueController {

	@Autowired
	EstoqueRepository repository;

	@RequestMapping("/form")
	public ModelAndView index(Estoque estoque) {
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
