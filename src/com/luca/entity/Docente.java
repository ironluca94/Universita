package com.luca.entity;

public class Docente {

	private int id_docente;
	private String nome_docente;
	private int id_materia;

	public Docente() {

	}

	public Docente(int id_docente, String nome_docente, int id_materia) {
		super();
		this.id_docente = id_docente;
		this.nome_docente = nome_docente;
		this.id_materia = id_materia;
	}

	public int getId_docente() {
		return id_docente;
	}

	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}

	public String getNome_docente() {
		return nome_docente;
	}

	public void setNome_docente(String nome_docente) {
		this.nome_docente = nome_docente;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	@Override
	public String toString() {
		return "Docente [id_docente=" + id_docente + ", nome_docente=" + nome_docente + ", id_materia=" + id_materia
				+ "]";
	}

}
