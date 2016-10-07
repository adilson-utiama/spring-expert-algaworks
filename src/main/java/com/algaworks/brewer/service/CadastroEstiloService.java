package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.exception.NomeEstiloJaCadastradoException;
import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo){
		Optional<Estilo> optional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if(optional.isPresent()){
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado.");
		}
		estilos.save(estilo);
	}
}
