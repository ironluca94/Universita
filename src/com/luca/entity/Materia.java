package com.luca.entity;

public class Materia {

	private int id_materia;
	private String nome_materia;
	private int corso_associato;
	private String nome_corso;

	public Materia() {

	}

	public Materia(int id_materia, String nome_materia, int corso_associato) {
		super();
		
		this.id_materia = id_materia;
		this.nome_materia = nome_materia;
		this.corso_associato = corso_associato;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getNome_materia() {
		return nome_materia;
	}

	public void setNome_materia(String nome_materia) {
		this.nome_materia = nome_materia;
	}

	public int getCorso_associato() {
		return corso_associato;
	}

	public void setCorso_associato(int corso_associato) {
		this.corso_associato = corso_associato;
	}

	@Override
	public String toString() {
		return "Materia [id_materia=" + id_materia + ", nome_materia=" + nome_materia + ", corso_associato="
				+ corso_associato + "]";
	}

	public String getNome_corso() {
		return nome_corso;
	}

	public void setNome_corso(String nome_corso) {
		this.nome_corso = nome_corso;
	}
	
	

}
