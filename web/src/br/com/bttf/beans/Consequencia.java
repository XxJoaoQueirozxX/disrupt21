package br.com.bttf.beans;

public class Consequencia {

	private Integer id;
	private String descricao;
	
	
	public Consequencia(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public Consequencia() {
	}


	
	
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
	
}

