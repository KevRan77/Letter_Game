package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Scanner;

public class Session extends Player{
	// *****  Variables  ***** \\ 
	String choiceNbPlayer = "Veuillez entrer le nombre de joueurs : ";
	String name;
	
	int keyEnter;
	int numberPlayer;
	
	Scanner sc = new Scanner(System.in);
	
	// ***** Méthodes ***** \\	
	public Session(){}
	
	public void getChoiceNbPlayer(){
		System.out.print(this.choiceNbPlayer);
	}
	
	public int getInt(){
		return this.keyEnter = sc.nextInt();
	}
	
	public String getString(){
		return this.name = sc.next();
	}
	
	public int showNbPlayer(){
		do{
			
			numberPlayer = getInt(); 
		}while(numberPlayer < 2);
		
		return numberPlayer;
	}
	
	public String[] getNameEnter(){
		int i;
		getChoiceNbPlayer();
		int nbPlayer = showNbPlayer();
		
		String[] tabName = new String[nbPlayer];
		
		for(i = 1; i <= nbPlayer;i++){
			System.out.println("Entrez le nom du Joueur "+i+" : ");
			tabName[i-1] = getString();
		}
		return tabName;
	}
}
