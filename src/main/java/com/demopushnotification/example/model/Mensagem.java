package com.demopushnotification.example.model;

public class Mensagem {
	
	private String titulo;

	private String subtitulo;

	private String descricao;
	
	public Mensagem() {
		super();
	}

	public Mensagem(String titulo, String subtitulo, String descricao) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
