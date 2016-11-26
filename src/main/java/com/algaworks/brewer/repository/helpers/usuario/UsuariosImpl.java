package com.algaworks.brewer.repository.helpers.usuario;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.repository.filter.UsuarioFilter;

public class UsuariosImpl implements UsuariosQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Usuario> porEmailEAtivo(String email) {
		String query = "from Usuario where lower(email) = lower(:email) and ativo = true";
		
		return manager.createQuery(query, Usuario.class)
					.setParameter("email", email)
					.getResultList()
					.stream()
					.findFirst();
	}

	@Override
	public List<String> permissoes(Usuario usuario) {
		String query = "select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u = :usuario";
		return manager.createQuery(query, String.class).setParameter("usuario", usuario).getResultList();
	}

	@Override
	public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
