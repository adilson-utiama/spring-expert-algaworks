package com.algaworks.brewer.repository.helpers.cerveja;

import java.util.List;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public List<Cerveja> filtrar(CervejaFilter filtro);
}
