package br.com.workshop.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Utilitario {

	static public void addMensagemFaces ( String msg ) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage (msg);
		context.addMessage(null, mensagem);
	}
}
