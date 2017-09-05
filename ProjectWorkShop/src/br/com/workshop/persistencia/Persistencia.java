package br.com.workshop.persistencia;

import javax.persistence.EntityManager;

import br.com.workshop.modelo.MercadoException;

public class Persistencia <E> {
	
	private Class<E> classe;
	protected EntityManager em;
	
	public Persistencia ( Class<E> classe ) {
		this.classe = classe;
		em = ConexaoJpa.criarEntityManager();
	}
	
	public void abrirTransacao () {
		em.getTransaction().begin();
	}
	
	public void commitTrasacao () {
		em.getTransaction().commit();
	}
	
	public void fechar () {
		em.close();
	}
	
	public void incluir ( E v ) throws MercadoException {
		try {
			
			abrirTransacao();
			em.persist(v);
			commitTrasacao();
			
		} catch (Exception e) {
			
			throw new MercadoException("Erro ao realizar a inclusao");
		}
	}
	
	public void excluir ( Object id ) throws MercadoException {
		try {
			abrirTransacao();
			E obj = em.find( classe, id );
			em.remove(obj);
			commitTrasacao();
		} catch (Exception e) {
			throw new MercadoException("Erro ao realizar a exclusao");
		}
	}
	
	public E alterar ( E v ) throws MercadoException {
		try {
			abrirTransacao();
			E obj = em.merge(v);
			commitTrasacao();
			return obj;
		} catch (Exception e) {
			throw new MercadoException("Erro ao realizar a alteracao");
		}
	}
	
	public E consultar ( Object id ) throws MercadoException {
		try {
			return em.find(classe, id);
		} catch (Exception e) {
			throw new MercadoException("Erro ao realizar a consulta");
		}
	}
}
