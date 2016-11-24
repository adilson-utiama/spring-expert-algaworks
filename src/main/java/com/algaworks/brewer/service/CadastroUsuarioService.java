package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.repository.Usuarios;
import com.algaworks.brewer.service.exception.EmailJaCadastradoException;

@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario){
		Optional<Usuario> optional = usuarios.findByEmailIgnoreCase(usuario.getEmail());
		if(optional.isPresent()){
			throw new EmailJaCadastradoException("E-Mail já cadastrado.");
		}
		return usuarios.saveAndFlush(usuario);
	}
}
