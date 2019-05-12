package com.luca.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.luca.entity.Studente;
import com.luca.entity.Voto;
import com.luca.service.StudenteService;
import com.luca.service.VotoService;

public class Main {
	
	
	

	public static void main(String[] args) {
		StudenteService ss = new StudenteService();
		VotoService vs = new VotoService();
		int scelta;
		
		do {
			Scanner input = new Scanner(System.in);

			System.out.println("\n1 per ottenere tutti gli studenti");
			System.out.println("2 per aggiungere uno studente");
			System.out.println("3 cambiare anno iscrizione");
			System.out.println("4 per eliminare uno studente");
			System.out.println("5 per ottenere i dati di uno studente");
			System.out.println("6 ottieni tutti gli studenti di un dato corso");
			
			System.out.println("7 aggiungi voto di uno studente");
			System.out.println("8 ottieni i voti di uno studente");

			System.out.println("Inserisci operazione: ");

			scelta = input.nextInt();

			if (scelta == 1) { // ottieni tutti gli student iscritti

				ArrayList<Studente> allStudents = ss.ottieniTuttiGliStudenti();
				
				for (Studente s : allStudents) {
					
					System.out.println(s);
				}
			}else if (scelta ==2) {
				
				Studente nuovoStu = new Studente("eros","pingani",3,"cf5");
				
				ss.aggiungiStudente(nuovoStu);
				
				
			}else if (scelta==5) {
				
				System.out.println(ss.ottieniStudente("cf1"));
				
			}else if (scelta == 3) {
				
				String codFisc = "cf1";
				int idCorso = 1;
				ss.modificaCorsoIscrizione(codFisc,idCorso);
				
			}else if (scelta == 6) {
				
				int idCorso = 1;
				ArrayList<Studente> lista = ss.ottieniStudentiCorso(idCorso);
				System.out.println("");
				for (Studente s : lista) {
					
					System.out.println(s);
				}
			}else if(scelta == 7) {
				
				int voto = 19;
				String cf = "cf1";
				int idMateria = 2;
				
				vs.aggiungiVoto(cf,idMateria,voto);
			}else if (scelta ==8) {
				
				String cf = "cf1";
				ArrayList<Voto> listaVoti = vs.ottieniVotoStudente(cf);
				
				
				for (Voto v: listaVoti) {
					
					System.out.println(v);
				}
			}
			
			
		} while (scelta != -1);

	}

}
