package com.luca.entity;

public class Studente {

	private int id_studente;
	private String nome;
	private String cognome;
	private String codFisc;
	private int id_corso; // fk per tabella corso
	private String corso;

	public Studente() {

	}

	public Studente(int id_studente, String nome, String cognome, int id_corso, String codFisc) {
		super();
		this.id_studente = id_studente;
		this.nome = nome;
		this.cognome = cognome;
		this.id_corso = id_corso;
		this.codFisc =codFisc;
		
	}
	
	public Studente(String nome, String cognome, int id_corso, String codFisc) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.id_corso = id_corso;
		this.codFisc =codFisc;
		
	}

	// getters e setters
	public int getId_studente() {
		return id_studente;
	}

	public void setId_studente(int id_studente) {
		this.id_studente = id_studente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getId_corso() {
		return id_corso;
	}

	public void setId_corso(int id_corso) {
		this.id_corso = id_corso;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	
	@Override
	public String toString() {
		return "Studente [id_studente=" + id_studente + ", nome=" + nome + ", cognome=" + cognome + ", codFisc="
				+ codFisc + ", corso=" + corso + "]";
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

}
