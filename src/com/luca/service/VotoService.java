package com.luca.service;

import java.util.ArrayList;

import com.luca.dao.MateriaDao;
import com.luca.dao.StudenteDao;
import com.luca.dao.VotoDao;
import com.luca.entity.Materia;
import com.luca.entity.Studente;
import com.luca.entity.Voto;

public class VotoService {

	StudenteDao stuDao = new StudenteDao();
	VotoDao votoDao = new VotoDao();
	MateriaDao materiaDao = new MateriaDao();

	public void aggiungiVoto(String cf, int idMateria, int valutazione) {

		Studente s = this.getStudente(cf);

		if (s == null) {
			System.out.println("Attenzione studente non registrato");
			return;
		}

		System.out.println("studente " + s);
		if (isVotoAggiungibile(valutazione, s.getId_studente(), idMateria)
				&& isMateriaCorretta(idMateria, s.getId_corso())) {

			Voto votoToAdd = new Voto(s.getId_studente(), idMateria, valutazione);
			votoDao.aggiungiVoto(votoToAdd);

		}

	}

	private boolean isMateriaCorretta(int idMateria, int idCorso) {

		// System.out.println(idCorso);
		Materia materia = materiaDao.getMateriaById(idMateria);
		System.out.println(materia);
		if (materia != null) {
			if (idCorso == materia.getCorso_associato()) {
				System.out.println("\nid Corso " + idCorso + "getCorso_associato() " + materia.getCorso_associato());
				return true;
			}
		} else {
			System.out.println("\nMateria inserita insesistente\n");
			return false;
		}
		System.out.println("\nAttenzione materia non corretta\n");
		return false;
	}

	private boolean isVotoAggiungibile(int voto, int idStudente, int idMateria) {

		if (isVotoAlreadyregistered(idStudente, idMateria)) { // se voto (materia + id) già stato inserito ritorno
			// false;
			System.out.println("\nAttenzione voto già inserito\n");
			return false;
		}

		if (voto >= 18 && voto <= 30) {
			return true;
		}
		System.out.println("\nAttenzione voto non aggiungibile\n");
		return false;
	}

	private boolean isVotoAlreadyregistered(int idStudente, int idMateria) {

		Voto voto = votoDao.findVotoByStudenteAndMateria(idStudente, idMateria);

		if (voto != null) { // ritorno true ovvero voto di uno studente per una determinata materia già
							// stato inserito
			return true;
		}
		return false;
	}

	public ArrayList<Voto> ottieniVotoStudente(String cf) {
		
		Studente s = getStudente(cf);
		
		if (s== null) {
			System.out.println("Attenzione studente non presente");
		}
		
		return votoDao.findAllVotoByStudente(s.getId_studente());
		
	}
	
	
	private Studente getStudente(String cf) {
		
		return stuDao.getStudenteByCodFisc(cf);

		
		
	}

}
