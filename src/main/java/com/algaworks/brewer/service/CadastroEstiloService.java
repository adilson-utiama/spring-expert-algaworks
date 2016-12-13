package com.algaworks.brewer.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.exception.NomeEstiloJaCadastradoException;
import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.exception.ImpossivelExcluirEntidadeException;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo){
		Optional<Estilo> optional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if(optional.isPresent() && estilo.isNovo()){
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado.");
		}
		return estilos.save(estilo);
	}

	@Transactional
	public void excluir(Estilo estilo) {
		try{
			estilos.delete(estilo);
			estilos.flush();
		}catch(PersistenceException e){
			throw new ImpossivelExcluirEntidadeException("impossível apagar estilo. Consta em algum item cerveja.");
		}
		
	}
}
