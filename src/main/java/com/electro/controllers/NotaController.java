package com.electro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.electro.entity.Nota;
import com.electro.repositories.NotaRepository;
import com.electro.utils.MapeamentoTelas;


@Controller
@RequestMapping("/nota")
public class NotaController {
	
	@Autowired
	NotaRepository notaRepository;
	
	@RequestMapping("/form")
	public ModelAndView form(Nota nota) {
		ModelAndView modelAndView = new ModelAndView(MapeamentoTelas.NOTA.getPath());
		modelAndView.addObject("nota", nota );
		return modelAndView;
	}
	
	
	@PostMapping("/salvar")
	public String salvar(Nota nota){
		notaRepository.save(nota);
		return MapeamentoTelas.NOTA.getPath();
	}
	
}
