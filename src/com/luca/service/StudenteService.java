package com.luca.service;

import java.util.ArrayList;

import com.luca.dao.StudenteDao;
import com.luca.entity.Studente;

public class StudenteService {

	private StudenteDao stuDao = new StudenteDao();

	public void aggiungiStudente(Studente studentToAdd) {

		if (ottieniStudente(studentToAdd.getCodFisc()) == null) {
			System.out.println("sn qui");
			stuDao.aggiungiStudente(studentToAdd);

		} else {
			System.out.println("Attenzione studente non aggiungibile");
		}

	}

	public void eliminaStudente(Studente studentToDelete) {

		if (this.ottieniStudente(studentToDelete.getCodFisc()) == null) { // se studente esiste

			stuDao.eliminaStudente(studentToDelete.getCodFisc());

		}

	}

	public void modificaCorsoIscrizione(String codFisc, int idCorso) {

		Studente s = this.ottieniStudente(codFisc);
		if (s != null) {

			if (s.getId_corso() > idCorso ) {  // ovvero se anno iscrizione nuovo > anno attuale (do per scontato che gli id dei corsi siano corrispondenti agli anni corso)

				stuDao.modificaAnnoIscrizioneStudente(codFisc, idCorso);

			}else {
				System.out.println("Attenzione operazione non consentita");
			}

		} else {
			System.out.println("Attenzione studente non iscritto!!!");
		}

	}

	public Studente ottieniStudente(String codFiscale) {

		Studente studente = stuDao.getStudenteByCodFisc(codFiscale);

		if (studente != null) { // ovvero se viene trovato uno studente dato un codice fiscale
			return studente;
		}

		return null;
	}

	public ArrayList<Studente> ottieniTuttiGliStudenti() {

		ArrayList<Studente> listaStudenti = stuDao.ottieniTuttiGliStudenti();

		return listaStudenti;

	}
	
	public ArrayList<Studente> ottieniStudentiCorso(int idCorso){
		
		ArrayList<Studente> studenti = stuDao.ottieniStudentiCorso(idCorso);
		
		return studenti;
	}

}
