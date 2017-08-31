package br.com.workshop.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemPedido {

	@Id
	@SequenceGenerator (name = "geradorItemPedido",
			sequenceName = "gerador_itemPedido",
			allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "geradorItemPedido")
	private int id;
	private int quantidade = 1;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Pedido pedido;
	
	ItemPedido() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemPedido(Produto produto, Pedido pedido){
		this.produto = produto;
		this.pedido = pedido;
	}
	
	public double getPrecoTotal(){
		return quantidade * produto.getPreco();
	}
	
	public boolean equals(Object obj){
		try {
			ItemPedido item = (ItemPedido) obj;
			return item.getProduto().equals(produto)
			&& item.getPedido().equals(pedido);
		} catch (Exception e) {
			return false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
