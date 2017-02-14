package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Session, Player {
	
	String choiceNbPlayer = "Veuillez entrer le nombre de joueurs : ";
	String name;
	String name2;
	
	int keyEnter;                                  	
	int numberPlayer;
	
	Player[] player = new Player[numberPlayer];
	String[] playerName = new String[numberPlayer];
	
	Scanner sc = new Scanner(System.in);
	
	public Game(){
		
		// *****  Variables  ***** \\ 
		String []names = getNameEnter();		
		Alphabet[] alphabet = Alphabet.values();
		Alphabet[] alphabet2 = new Alphabet[numberPlayer];
		
		
		
		start(alphabet, alphabet2, numberPlayer, names, player, playerName);
		
		
	}
	
	public String getName(String name2){
		return this.name2 = name2;
	}
	
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
	
	public void start(Alphabet[] alphabet, Alphabet[] alphabet2, int nbPlayer, String[] names, Player[] player, String[] playerName){
		char letterChosen;
		int j;
		int i;
		String a;
		ArrayList abc = new ArrayList();
		ArrayList finalBag = new ArrayList();
		int[] tabPlayerStart = new int[numberPlayer];
		
		
		for(i=0; i < nbPlayer; i++){
			
			letterChosen = alphabet[0].random();	
			alphabet[i].setChar(letterChosen);
			alphabet[i].setValue(letterChosen);
			//System.out.println("salut toi"+ alphabet[i].getValue());
			for(j=0;j<25;j++){
				//System.out.println("salut toi "+alphabet[0].getChar());
				if(alphabet[j].getChar()==letterChosen){
					alphabet2[i] = alphabet[j];
					//System.out.println("Valeur de la lettre"+alphabet2[i].getChar());
				}
			}
			System.out.println("Lettre aléatoire du Player "+names[i]+" : "+ letterChosen);
			abc = mutualBag(letterChosen);
			finalBag.add(abc);
			tabPlayerStart[i] = alphabet2[i].getValue();
			System.out.println("Valeur du joueur " +i+ " : " +tabPlayerStart[i]);
			
			//playerName[i] = player[i].getName(names[i]);
		//	System.out.println("Joueur qui commence : "+ playerName[i]);
			
	}
		System.out.println("Pot commun : "+finalBag);
}
	
	public ArrayList<Character> mutualBag(char letter){
		
		ArrayList<Character> potCommun = new ArrayList<Character>();
		potCommun.add(letter); 
		
		return potCommun;
	}
	
	
	public void firstPlayer(int nbPlayer, String[] playerName){
		int bubbleInd;
		int i,j;
		String bubblePlayer;
		int[] start = new int[nbPlayer];
		
		
		
		for(j=0; j <= nbPlayer; j++){
			for(i=1; i < nbPlayer; i++){
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
	}
}
