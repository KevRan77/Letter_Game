package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;

public class Game extends Session {
	
	
	public Game(){
		// *****  Variables  ***** \\ 
		String []names = getNameEnter();		
		Alphabet[] alphabet = Alphabet.values();		
		Alphabet[] alphabet2 = new Alphabet[numberPlayer];
		int nbPlayer = numberPlayer;
		
		start(alphabet, alphabet2, nbPlayer, names);
		
		
	}
	
	public void start(Alphabet[] alphabet, Alphabet[] alphabet2, int nbPlayer, String[] names){
		char letterChosen;
		int j;
		int i;
		//Player[] Player = new Player[nbPlayer];
		//int[] tabPlayerStart = new int[nbPlayer];
		//String[] playerName = new String[nbPlayer];
		
		for(i=0; i < nbPlayer; i++){
			letterChosen = Alphabet.random();
			for(j=0;j<25;j++){
				if(alphabet[j].getChar()==letterChosen){
					alphabet2[i] = alphabet[j];
				}
			}
			System.out.println("Lettre aléatoire du Player "+names[i]+" : "+ letterChosen);
			mutualBag(letterChosen);
			//tabPlayerStart[i] = alphabet[i].getValue();
			//System.out.println(tabPlayerStart[i]);
			//playerName[i] = Player[i].getName(names[i]);
			
	}
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
