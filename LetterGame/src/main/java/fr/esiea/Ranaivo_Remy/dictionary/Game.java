package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;

public class Game extends Session {
	
	
	public Game(){
		// *****  Variables  ***** \\ 
		String []names = getNameEnter();		
		Alphabet[] alphabet = Alphabet.values();
		Alphabet[] alphabet2 = new Alphabet[200];
		int nbPlayer = numberPlayer;
		
		start(alphabet, alphabet2, nbPlayer, names);
		
		
	}
	
	public void start(Alphabet[] alphabet, Alphabet[] alphabet2, int nbPlayer, String[] names){
		char letterChosen;
		int j;
		int i;
		ArrayList abc = new ArrayList();
		ArrayList finalBag = new ArrayList();
		Player[] player = new Player[nbPlayer];
		int[] tabPlayerStart = new int[nbPlayer];
		String[] playerName = new String[nbPlayer];
		
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
			//System.out.println("Joueur qui commence : "+ playerName[0]);
			
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
