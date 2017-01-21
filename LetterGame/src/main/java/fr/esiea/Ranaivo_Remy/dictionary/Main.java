package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		
		System.out.println("Entrez le nom du joueur 1 : ");
		String name1 = sc.next();
		System.out.println("Entrez le nom du joueur 2 : ");
		String name2 = sc.next();
		
		Alphabet alphabet = new Alphabet();
		Alphabet alphabet2 = new Alphabet();
		ArrayList potCommun = new ArrayList();
		
		System.out.println("Lettre aléatoire du joueur "+joueur1.getName(name1)+" : "+ alphabet.getLetter());
		System.out.println("Lettre aléatoire du joueur "+joueur2.getName(name2)+" : "+ alphabet2.getLetter());
		
		potCommun.add(alphabet.getLetter());
		potCommun.add(alphabet2.getLetter());
		
		System.out.println("Pot commun : "+potCommun);
		
		
	
	}

}
