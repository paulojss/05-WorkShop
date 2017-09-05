package br.com.workshop.persistencia;

import java.util.List;

import javax.persistence.Query;

import br.com.workshop.modelo.Produto;

public class ProdutoDao extends Persistencia<Produto> { 
	
	public ProdutoDao () {
		super ( Produto.class );
	}
	
	public List<Produto> listarPorDescricao ( String descricao ) {
		Query query =  em.createQuery("select produto from Produto produto where upper(produto.descricao) like :descricao");
		query.setParameter ( "descricao", "%"+descricao.toUpperCase()+"%" );
		return query.getResultList();
	}
}
