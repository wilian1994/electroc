package com.electro.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.electro.entity.Estoque;
import com.electro.repositories.EstoqueRepository;
import com.electro.repositories.RecebimentoRepository;
import com.electro.utils.MapeamentoTelas;
import com.electro.utils.Recebimento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("recebimento")
public class RecimentoController {
	
	@Autowired
	EstoqueRepository erepository;
	
	@Autowired
	RecebimentoRepository rrepository;
	
	@GetMapping
	public ModelAndView recebimento() {
		ModelAndView modelAndView = new ModelAndView(MapeamentoTelas.RECEBIMENTO.getPath());
		return modelAndView;
	}
	
	@GetMapping("/buscaInfoRecebimento/{codigo}")
	@ResponseBody
	public String buscaInfo(@PathVariable("codigo") String codigo) throws JsonProcessingException {
		Estoque estoque = erepository.findByCodigo(codigo);
		return new ObjectMapper().writeValueAsString(estoque);

	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@RequestParam("codigo") String codigo, @RequestParam("quantidade")int quantidade){
		ModelAndView modelAndView = new ModelAndView(MapeamentoTelas.RECEBIMENTO.getPath());
		Estoque estoque = erepository.findByCodigo(codigo);
		estoque.insereProduto(quantidade);
		erepository.save(estoque);
		rrepository.save(new Recebimento(estoque, LocalDate.now(), quantidade));
		return modelAndView;
	}

	
}
