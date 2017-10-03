
package br.com.workshop.controle;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.servlet.http.HttpServletRequest;

import br.com.workshop.modelo.ItemPedido;
import br.com.workshop.modelo.MercadoException;
import br.com.workshop.modelo.Pedido;
import br.com.workshop.modelo.Produto;
import br.com.workshop.persistencia.PedidoDao;
import br.com.workshop.persistencia.ProdutoDao;
import br.com.workshop.util.Utilitario;

public class PedidoControl {

	private String descricao;
	private List<Produto> listaProdutos;
	private DataModel produtos;
	private Produto produto;
	private Pedido pedido = new Pedido();
	private DataModel itens;
	
	public void listarProdutos ( ActionEvent evento ) {
		ProdutoDao pdao = new ProdutoDao();
		listaProdutos = pdao.listarPorDescricao(descricao);
	}
	
	public void confirmarCompra ( ActionEvent evento ) {
		HttpServletRequest request = ( HttpServletRequest )FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		
		ClienteControl clienteControl = ( ClienteControl ) request.
				getSession().getAttribute("clienteControl");
		pedido.setCliente(clienteControl.getCliente());
		PedidoDao pedidoDao = new PedidoDao();
		try {
			pedidoDao.incluir(pedido);
			Utilitario.addMensagemFaces("Pedido incluido com sucesso.");
		} catch (MercadoException e) {
			Utilitario.addMensagemFaces(e.getMessage());
		}
	}
	
	public void excluirProdutoCarrinho ( ActionEvent evento ) {
		ItemPedido item = ( ItemPedido ) itens.getRowData();
		pedido.removerItem(item);
	}
	
	public void selecionarProduto ( ActionEvent evento ) {
		 produto = ( Produto ) produtos.getRowData();
	}
	
	public void comprar ( ActionEvent evento ) {
		pedido.addProduto(produto);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public DataModel getProdutos() {
		return produtos;
	}
	public void setProdutos(DataModel produtos) {
		this.produtos = produtos;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public DataModel getItens() {
		return itens;
	}
	public void setItens(DataModel itens) {
		this.itens = itens;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
