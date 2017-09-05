package br.com.workshop.controle;

import java.awt.event.ActionEvent;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.workshop.modelo.Cep;
import br.com.workshop.modelo.Cliente;
import br.com.workshop.modelo.MercadoException;
import br.com.workshop.persistencia.CepDao;
import br.com.workshop.persistencia.ClienteDao;
import br.com.workshop.util.Utilitario;

public class ClienteControl {
	
	private Cliente cliente = new Cliente();
	
	private String email;
	private String senha;
	private String cepString;
	private boolean autenticado;
	
	public void autenticar (ActionEvent evento) {
		ClienteDao clienteDao = new ClienteDao();
		try {
			cliente = clienteDao.autenticar(email, senha);
			autenticado = true;
		} catch (Exception e) {
			Utilitario.addMensagemFaces(e.getMessage());
			autenticado = false;
		}
	}
	
	public void logout ( ActionEvent evento ) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().invalidate();
	}
	
	public void consultarCep ( ActionEvent evento ) {
		CepDao cepDao = new CepDao();
		try {
			Cep cep = cepDao.consultar(cepString);
			cliente.setCep(cep);
		} catch (MercadoException e) {
			Utilitario.addMensagemFaces(e.getMessage());
		}
	}
	
	public String confirmarCliente() {
		if (!senha.equals(cliente.getSenha())) {
			Utilitario.addMensagemFaces("As senhas devem ser iguais");
			return null;
		}
		
		ClienteDao cdao = new ClienteDao();
		try {
			cdao.alterar(cliente);
			Utilitario.addMensagemFaces("confirmacao realizada com sucesso");
			autenticado = true;
			return "confirmado";
		} catch (MercadoException e) {
			Utilitario.addMensagemFaces(e.getMessage());
			return null;
		}
	}
	
	public Cliente getCliente () {
		return cliente;
	}
	
	
}
