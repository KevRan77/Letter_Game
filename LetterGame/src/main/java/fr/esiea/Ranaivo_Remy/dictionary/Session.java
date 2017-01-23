package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Scanner;

public class Session {
	String choixNbJoueur = "Veuillez entrer le nombre de joueurs : ";
	String nameEnter = "Entrez le nom du Player";
	int keyEnter;
	Scanner sc = new Scanner(System.in);
	String name;
	
	public Session(){
		
	}
	public void getChoixNbPlayer(){
		System.out.print(this.choixNbJoueur);
	}
	
	public int getInt(){
		return this.keyEnter = sc.nextInt();
	}
	
	public String getString(){
		return this.name = sc.next();
	}
}
