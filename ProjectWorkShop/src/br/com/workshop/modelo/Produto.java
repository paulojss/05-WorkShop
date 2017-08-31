package br.com.workshop.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto {

	@Id
	@SequenceGenerator(name="geradorProduto",
			sequenceName="gerador_produto",
			allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "geradorProduto")
	private int id;
	private String descricao;
	private double preco;
	private String foto;
	
	public boolean euals (Object obj){
		try{
			Produto p = (Produto)obj;
			return p.getDescricao().equals(descricao) 
					&& p.getId()== id;
		}catch(Exception e){
			return false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
