package com.luca.entity;

public class Corso {

	private int id_corso;
	private String nome_corso;

	public Corso() {

	}

	public Corso(int id_corso, String nome_corso) {
		super();
		this.id_corso = id_corso;
		this.nome_corso = nome_corso;
	}

	public int getId_corso() {
		return id_corso;
	}

	public void setId_corso(int id_corso) {
		this.id_corso = id_corso;
	}

	public String getNome_corso() {
		return nome_corso;
	}

	public void setNome_corso(String nome_corso) {
		this.nome_corso = nome_corso;
	}

	@Override
	public String toString() {
		return "Corso [id_corso=" + id_corso + ", nome_corso=" + nome_corso + "]";
	}

}
