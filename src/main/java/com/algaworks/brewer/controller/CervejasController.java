package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.Cervejas;

@Controller
@RequestMapping("/cervejas/")
public class CervejasController {

	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping("novo")
	public String novo(Cerveja cerveja){
		cervejas.findAll();
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping( value = "novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model,
				RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(cerveja);
		}
		System.out.println(cerveja.getSku());
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return "redirect:novo";
	}
	
		
}
