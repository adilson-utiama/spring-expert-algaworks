package com.algaworks.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Venda;
import com.algaworks.brewer.repository.helpers.venda.VendasQueries;

@Repository
public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries{

}
