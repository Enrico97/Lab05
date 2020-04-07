package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	DizionarioDAO dizionario = new DizionarioDAO();
	private List<Parola> soluzione ;
	
	public List<Parola> anagrammi(String parola) {
		this.soluzione = new ArrayList<>() ;
		
		parola=parola.toLowerCase() ;
		
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ;
		}
		
		// avvia la ricorsione
		cerca("", 0, disponibili) ; 
		
		return this.soluzione ;
	}
	
	private void cerca( String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) { 
			// caso terminale
			Parola parola = new Parola(parziale);
			// if(parziale è nel dizionario)
			if (dizionario.isCorrect(parziale)) {
				parola.setCorretta(true);
				}
			if (!soluzione.contains(parola))
				this.soluzione.add(parola) ;
		}
		
		// caso normale
		// provare ad aggiungere a 'parziale' tutti i caratteri presenti tra
		// i 'disponibili'
		for(Character ch: disponibili) {
			String tentativo = parziale + ch ;
			
			List<Character> rimanenti = new ArrayList<>(disponibili) ;
			rimanenti.remove(ch) ;
			
			cerca( tentativo, livello+1, rimanenti) ;
		}
	}


}
