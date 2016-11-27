package com.algaworks.brewer.repository.helpers.usuario;

import java.util.List;
import java.util.Optional;

import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.repository.filter.UsuarioFilter;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	public List<String> permissoes(Usuario usuario);
	public List<Usuario> filtrar(UsuarioFilter filtro);
}
