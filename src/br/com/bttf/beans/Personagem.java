package br.com.bttf.beans;

import java.util.List;

public class Personagem {

	private Integer id;
	private String nome;
	private String ator;
	private String relacao;
	private String urlFoto;
	private String descricao;
	private boolean viajante;
	private boolean alternativo;
	
	
	public Personagem(Integer id, String nome, String ator, String relacao, String urlFoto,
			String descricao, boolean viajante, boolean alternativo) {
		this.id = id;
		this.nome = nome;
		this.ator = ator;
		this.relacao = relacao;
		this.urlFoto = urlFoto;
		this.descricao = descricao;
		this.viajante = viajante;
		this.alternativo = alternativo;
	}

	public Personagem(Integer id, String nome, Integer idade, String ator, String relacao, String urlFoto,
			String descricao, boolean viajante, boolean alternativo) {
		this.id = id;
		this.nome = nome;
		this.ator = ator;
		this.relacao = relacao;
		this.urlFoto = urlFoto;
		this.descricao = descricao;
		this.viajante = viajante;
	}



	public Personagem() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getRelacao() {
		return relacao;
	}

	public void setRelacao(String relacao) {
		this.relacao = relacao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isViajante() {
		return viajante;
	}

	public void setViajante(boolean viajante) {
		this.viajante = viajante;
	}

	public boolean isAlternativo() {
		return alternativo;
	}

	public void setAlternativo(boolean alternativo) {
		this.alternativo = alternativo;
	}
		
	
	@Override
	public String toString() {
		return String.format("< %s >", getNome());
	}
}


