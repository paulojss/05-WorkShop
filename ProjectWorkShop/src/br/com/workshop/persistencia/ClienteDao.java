package br.com.workshop.persistencia;

import javax.persistence.Query;

import br.com.workshop.modelo.Cliente;
import br.com.workshop.modelo.MercadoException;

public class ClienteDao extends Persistencia<Cliente> {
	
	public ClienteDao () {
		super (Cliente.class);
	}
	
	public void incluir ( Cliente cliente ) throws MercadoException {
		Cliente c = consultar(cliente.getEmail());
		if ( c == null ){
			super.incluir(cliente);
		} else {
			throw new MercadoException("Ja existe um cliente com este email cadastrado");
		}
	}

	public Cliente autenticar ( String email, String senha ) throws MercadoException {
		try {
			Query query = em.createQuery("select c from Cliente c where c.email = :email and c.senha = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			throw new MercadoException("Usuario ou senha incorretos");
		}
	}
}
