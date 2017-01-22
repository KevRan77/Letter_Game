package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int nbJoueur;
		int i;
		Scanner sc = new Scanner(System.in);
		do{
		System.out.print("Veuillez entrer le nombre de joueurs : ");
		nbJoueur = sc.nextInt();
		}while(nbJoueur < 1 || nbJoueur > 5);
		Joueur[] joueur = new Joueur[nbJoueur];
		String[] a = new String[nbJoueur];
		Alphabet[] alphabet = new Alphabet[nbJoueur];
		ArrayList potCommun = new ArrayList();
		
		for(i = 1; i <= nbJoueur; i++){
			joueur[i-1] = new Joueur();
			System.out.println("Entrez le nom du joueur "+i+" : ");
			a[i-1] = sc.next();
			
			alphabet[i-1] = new Alphabet();
		}
		
		for(i=0; i < nbJoueur; i++){
			System.out.println("Lettre aléatoire du joueur "+joueur[i].getName(a[i])+" : "+ alphabet[i].getLetter());
			potCommun.add(alphabet[i].getLetter());
		}
		System.out.println("Pot commun : "+potCommun);
	
	}

}
