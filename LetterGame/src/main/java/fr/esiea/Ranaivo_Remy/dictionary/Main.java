package fr.esiea.Ranaivo_Remy.dictionary;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;*/

public class Main {

	public static void main(String[] args) {
		
		//Player player = new Player();
		Game game = new Game();
		
		
		/*int nbPlayer;
		int i;
		Scanner sc = new Scanner(System.in);
		do{
		System.out.print("Veuillez entrer le nombre de Players : ");
		nbPlayer = sc.nextInt();
		}while(nbPlayer < 2 || nbPlayer > 5);
		Player[] Player = new Player[nbPlayer];
		String[] a = new String[nbPlayer];
		Alphabet[] alphabet2 = new Alphabet[nbPlayer];
		Alphabet[] alphabet = Alphabet.values();
		
		int[] start = new int[nbPlayer];
		
		ArrayList potCommun = new ArrayList();
		String[] playerName = new String[nbPlayer];
		
		
		for(i = 1; i <= nbPlayer; i++){
			Player[i-1] = new Player();
			System.out.println("Entrez le nom du Player "+i+" : ");
			a[i-1] = sc.next();
		}
		char letterChosen;
		int j;
		for(i=0; i < nbPlayer; i++){
			letterChosen = alphabet[i].random();
			for(j=0;j<25;j++){
				if(alphabet[j].getChar()==letterChosen){
					alphabet2[i] = alphabet[j];
				}
			}
			System.out.println("Lettre aléatoire du Player "+Player[i].getName(a[i])+" : "+ letterChosen);
			 potCommun.add(letterChosen); 
			start[i] = alphabet2[i].getValue();
			playerName[i] = Player[i].getName(a[i]);
		}
		int bubbleInd;
		String bubblePlayer;
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
		System.out.println("Player qui commence : "+playerName[0]);
		System.out.println("Pot commun : "+potCommun);*/
		
		
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
