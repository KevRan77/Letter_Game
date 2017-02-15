package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements IGame {
	// *****  Variables  ***** \\
	String choiceNbPlayer = "Veuillez entrer le nombre de joueurs : ";

	int keyEnter;                                  	
	int numberPlayer;
	
	Player[] tabPlayer = new Player[numberPlayer];
	String[] playerName = new String[numberPlayer];
	
	ArrayList<Character> potCommun = new ArrayList<Character>();
	
	Scanner sc = new Scanner(System.in);
	
	// *****  Méthodes ***** \\
	
	//Methode Game qui lance la première partie du jeu
	public Game(){
		
		Alphabet[] alphabet = Alphabet.values();
		Alphabet[] alphabet2 = new Alphabet[numberPlayer];
		
		startGame(alphabet, alphabet2 );
	}
	
	//Affiche le nombre de joueurs
	public void getChoiceNbPlayer(){
		System.out.print(this.choiceNbPlayer);
	}
	
	//Récupère un entier entré au clavier (nombre de joueurs)
	public int getInt(){
		return this.keyEnter = sc.nextInt();
	}
	
	//Récupère un mot écris au clavier (nom du joueur)
	public String getString(){
		return sc.next();
	}
	
	//Permet à l'utilisateur d'entrer le nombre de joueur pour la partie
	public void setNbPlayer(){
		do{
			this.numberPlayer = getInt(); 
			this.tabPlayer = new Player[this.numberPlayer];
		}while(numberPlayer < 2);
	}
	

	//Initialise le tableau de joueur avec des joueurs "null"
	public void initTabPlayer(){
		for(int i = 0; i<this.numberPlayer; i++){
			this.tabPlayer[i] = new Player();
		}
	}
	
	//Récuèpre le nom de chaque joueur et stocke dans un tableau
	public void setNameEnter(){
		int i;
		getChoiceNbPlayer();
		setNbPlayer();
		initTabPlayer();
		
		for(i = 0; i < this.tabPlayer.length ;i++){
			System.out.println("Entrez le nom du Joueur "+i+" : ");
			this.tabPlayer[i].name = getString();
		}
	}
	
	void playerStarterDraw(Player player){
		char letterChosen;
		
		for(int i =0; i<2;i++){
			letterChosen = Alphabet.random();
			mutualBag(letterChosen);
			System.out.println("Le joueur "+player.name+" a pioché : "+letterChosen);
		}
		printMutualBag();
	}
	
	//Attribut une lettre aléatoire aux joueurs et remplit ces lettres dans le pot commun
	public void firstDraw(Player[] tabPlayer, Alphabet[] alphabet,Alphabet[] alphabet2 ){
		int i,j;
		char letterChosen;
		
		for(i=0; i<tabPlayer.length; i++){
			letterChosen = Alphabet.random();	
			alphabet[i].setChar(letterChosen);
			alphabet[i].setValue(letterChosen);
	
			for(j=0;j<25;j++){	
				if(alphabet[j].getChar()==letterChosen){
					mutualBag(letterChosen);
					tabPlayer[i].val = alphabet[j].getValue();
					System.out.println("Le joueur "+tabPlayer[i].name+" a pioché la lettre "+letterChosen);
				}
			}
		}
	}
	
	//Affiche le contenu du pot commun
	public void printMutualBag(){
		System.out.println("Pot commun : "+this.potCommun);
	}
	
	//Regroupement des fonctions pour lancer le jeu
	public void startGame(Alphabet[] alphabet, Alphabet[] alphabet2){
		setNameEnter();
		firstDraw(this.tabPlayer, alphabet, alphabet2);
		Player player = whoStart();
		printMutualBag();
		playerStarterDraw(player);
	}
	
	//Affiche quel est le joueur qui commence
	public Player whoStart(){
		sortArray();
		System.out.println("Le joueur "+this.tabPlayer[0].name+" commence.");
		return this.tabPlayer[0];
	}
	
	//Tri a bulle sur le tableau de joueur pour connaître celui à la plus petite lettre
	public void sortArray(){
		int i,j;
		Player flag;
		
		for(i=0; i< this.tabPlayer.length; i++){
			for(j=1; j < this.tabPlayer.length; j++){
				if(this.tabPlayer[j-1].val > this.tabPlayer[j].val ){
					flag = this.tabPlayer[j];
					this.tabPlayer[j] = this.tabPlayer[j-1];
					this.tabPlayer[j-1] = flag;
				}
			}
		}
	}
	
	//Ajout de lettre dans le pot commun
	public void mutualBag(char letter){
			this.potCommun.add(letter); 
		}
}
