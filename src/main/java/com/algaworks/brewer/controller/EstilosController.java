package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estilos/")
public class EstilosController {

	@RequestMapping("novo")
	public String novo(){
		return "estilos/CadastroEstilo";
	}
}
