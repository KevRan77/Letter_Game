package fr.esiea.Ranaivo_Remy.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		}while(nbJoueur < 2 || nbJoueur > 5);
		Joueur[] joueur = new Joueur[nbJoueur];
		String[] a = new String[nbJoueur];
		Alphabet[] alphabet = new Alphabet[nbJoueur];
		Alphabet[] alphabet2 = Alphabet.values();
		int[] start = new int[nbJoueur];
		ArrayList potCommun = new ArrayList();
		String[] playerName = new String[nbJoueur];
		
		
		for(i = 1; i <= nbJoueur; i++){
			joueur[i-1] = new Joueur();
			System.out.println("Entrez le nom du joueur "+i+" : ");
			a[i-1] = sc.next();
			
			//alphabet[i-1] = new Alphabet();
		}
		char letterChosen;
		int j;
		for(i=0; i < nbJoueur; i++){
			letterChosen = alphabet[i].random();
			if(letterChosen == 'A'){
				alphabet[i] = Alphabet.A;
			}
			if(letterChosen == 'B'){
				alphabet[i] = Alphabet.B;
			}
			if(letterChosen == 'C'){
				alphabet[i] = Alphabet.C;
			}
			if(letterChosen == 'D'){
				alphabet[i] = Alphabet.D;
			}
			if(letterChosen == 'E'){
				alphabet[i] = Alphabet.E;
			}
			if(letterChosen == 'F'){
				alphabet[i] = Alphabet.F;
			}
			
			/*if(alphabet[j].getChar() == letterChosen){
				System.out.println("getChar : "+alphabet[i].getChar()+ "random : "+letterChosen);
			}*/
			System.out.println("Lettre aléatoire du joueur "+joueur[i].getName(a[i])+" : "+ letterChosen);
			 potCommun.add(letterChosen); 
			start[i] = alphabet[i].getValue();
			playerName[i] = joueur[i].getName(a[i]);
			// System.out.println("Joueur qui commence : "+alphabet[i]);
			//System.out.println("Joueur qui commence : "+alphabet[i].getValue());*/
		}
		int bubbleInd;
		String bubblePlayer;
		for(j=0; j <= nbJoueur; j++){
		for(i=1; i < nbJoueur; i++){
			if(start[i-1] > start[i]){
				bubbleInd = start[i];
				start[i] = start[i-1];
				start[i-1] = bubbleInd;
				
				bubblePlayer = playerName[i];
				playerName[i] = playerName[i-1];
				playerName[i-1] = bubblePlayer;
					}
				}
			}
		System.out.println("Joueur qui commence : "+playerName[0]);
		System.out.println("Pot commun : "+potCommun);
		
		
	/*	for (int i = 0; i < 100; i++ )
            System.out.print(Alphabet.random());*/

	
		/*Alphabet test = Alphabet.A;
		Alphabet test2 = Alphabet.B;
		if(test.getValue() < test2.getValue()){
			System.out.println("A<B");
		}else{
			System.out.println("A>B");
		}
		System.out.println(test.getValue());
		
		Alphabet[] alphabet = Alphabet.values();
		System.out.println(""+alphabet[0] + ","+alphabet[1]);*/
		/* Alphabet[] alphabet = Alphabet.values();
	        char letterChosen = alphabet[0].random();
			System.out.println("getChar : "+alphabet[0].getChar());*/
          
	}
		
		
}
