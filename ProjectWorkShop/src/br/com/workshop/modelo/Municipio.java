package br.com.workshop.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Municipio {

	@Id
	@SequenceGenerator(name="geradorMunicipio", allocationSize=1, initialValue=1, sequenceName="gerador_municipio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "geradorMunicipio" )
	private Integer id = 0;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private EnumUf uf;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public EnumUf getUf() {
		return uf;
	}
	public void setUf(EnumUf uf) {
		this.uf = uf;
	}
}
