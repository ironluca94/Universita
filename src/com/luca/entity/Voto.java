package com.luca.entity;

public class Voto {

	private int id_voto;
	private int id_studente;
	private int id_materia;
	private int voto;
	private String nomeMateria;

	public Voto() {

	}

	public Voto(int id_studente, int id_materia, int voto) {
	
		
		this.id_studente = id_studente;
		this.id_materia = id_materia;
		this.voto = voto;
	}

	public int getId_voto() {
		return id_voto;
	}

	public void setId_voto(int id_voto) {
		this.id_voto = id_voto;
	}

	public int getId_studente() {
		return id_studente;
	}

	public void setId_studente(int id_studente) {
		this.id_studente = id_studente;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	@Override
	public String toString() {
		return "Voto [id_studente=" + id_studente + ", id_materia=" + id_materia + ", voto=" + voto + ", nomeMateria="
				+ nomeMateria + "]";
	}
	
	

	

}
