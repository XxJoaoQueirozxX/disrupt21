package br.com.bttf.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Acontecimento {
	
	private Integer id;
	private String descricao;
	private String nome;
	private boolean alternativo;
	private String urlFoto;
	private List<Personagem> personagens;
	private Consequencia consequencia;
	private LocalDate data;
	
	public Acontecimento(Integer id, String descricao, String nome, LocalDate data, boolean alternativo,
			String urlFoto, List<Personagem> personagens, Consequencia consequencia) {
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.data = data;
		this.alternativo = alternativo;
		this.urlFoto = urlFoto;
		this.personagens = personagens;
		this.consequencia = consequencia;
		
	}
	
	public Acontecimento(Integer id, String descricao, String nome, boolean alternativo,
			String urlFoto, List<Personagem> personagens, LocalDate data) {
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.alternativo = alternativo;
		this.urlFoto = urlFoto;
		this.personagens = personagens;
		this.data = data;
	}
	
	public Acontecimento() {
		
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAlternativo() {
		return alternativo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setAlternativo(boolean alternativo) {
		this.alternativo = alternativo;
	}
	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}

	public Consequencia getConsequencia() {
		return consequencia;
	}

	public void setConsequencia(Consequencia consequencia) {
		this.consequencia = consequencia;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
}
