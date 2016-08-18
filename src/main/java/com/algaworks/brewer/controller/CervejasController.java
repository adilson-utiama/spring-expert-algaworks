package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algaworks.brewer.model.Cerveja;

@Controller
@RequestMapping("/cervejas/")
public class CervejasController {

	@RequestMapping("novo")
	public String novo(){
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping( value = "novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja){
		System.out.println(cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
}
