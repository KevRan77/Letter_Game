package fr.esiea.Ranaivo_Remy.Game;

import java.util.Scanner;

public class Game implements IGame {
	// *****  Variables  ***** \\
	int keyEnter, numberPlayer;
	
	Player[] tabPlayer = new Player[numberPlayer];
	String[] playerName = new String[numberPlayer];
	
	//Singleton
	MutualBag mutualBag = MutualBag.getInstanceMutualBag();
	LetterDraw letterDraw = new LetterDraw();
	Words words = new Words();
	
	Scanner sc = new Scanner(System.in);
	
	// *****  Méthodes ***** \\
	
	//Méthode Game qui lance la première partie du jeu
	public Game(){
		Alphabet[] alphabet = Alphabet.values();

		startGame(alphabet);
	}
	
	//Récupère un mot écris au clavier (nom du joueur)
	public String getString(){
		return sc.next();
	}
	
	//Permet à  l'utilisateur d'entrer le nombre de joueur pour la partie
	public void setNbPlayer(){
		do{
			System.out.println("Veuillez entrer le nombre de joueurs, minimum 2 : ");
			if (sc.hasNextInt()) this.numberPlayer = sc.nextInt();
	        else {
	        	System.out.println("La valeur saisie n'est pas un entier!");
	            sc.next();
	            continue;
	        }
			this.tabPlayer = new Player[this.numberPlayer];
		}while(numberPlayer < 2 );
	}
	

	//Initialise le tableau de joueur avec des joueurs "null"
	public void initTabPlayer(){
		for(int i = 0; i<this.numberPlayer; i++){
			this.tabPlayer[i] = new Player();
			this.tabPlayer[i].listWord.remove("null");
		}
	}
	
	//Initialise le pot commun
	public void initMutualBag(){
		this.mutualBag.getMutualBag().remove(null);
	}
	
	//Récupère le nom de chaque joueur et stocke dans un tableau
	public void setNameEnter(){
		//int i;
		setNbPlayer();
		initTabPlayer();
		initMutualBag();
		
		//Design Pattern : iterator
		for(Player iterator : this.tabPlayer){
			System.out.println("Entrez le nom du Joueur : ");
			iterator.name = getString();
		}
		
	}
	

	//Regroupement des fonctions pour lancer le jeu
	public void startGame(Alphabet[] alphabet){
		setNameEnter();
		letterDraw.firstDraw(this.tabPlayer, alphabet, mutualBag);
		Player player = whoStart(this.tabPlayer);
		mutualBag.printMutualBag();
		//playerStarterDraw(player);
		//String word = sc.next();
		turnPlayer(this.tabPlayer);
		//System.out.println(verifLetterMutualBag(word, this.potCommun));
		//findWord();
	}
	
	//Affiche quel est le joueur qui commence
	public Player whoStart(Player[] tabPlayer){
		tabPlayer = sortArray(tabPlayer);
		tabPlayer[0].play = true;
		System.out.println("Le joueur "+tabPlayer[0].name+" commence.");
		return tabPlayer[0];
	}
	
	//Permet au joueur de jouer 
	public void turnPlayer(Player[] tabPlayer){	
		for(int i = 0; i < tabPlayer.length; i++){
			if(tabPlayer[i].play == true && tabPlayer[i].score <10){
				System.out.println(tabPlayer[i].name+" joue");
				letterDraw.playerStarterDraw(tabPlayer[i], mutualBag);
				choiceAction(i);
			}
		}
		
	}	
	
	//Passe le tour du joueur
	public void passTurn(int idPlayer, Player[] tabPlayer){
		if(tabPlayer.length-1 == idPlayer){
			tabPlayer[idPlayer].play = false;
			tabPlayer[0].play = true;
		}
		else{
			tabPlayer[idPlayer].play = false;
			tabPlayer[idPlayer+1].play = true;
		}
	}
	
	//Affiche les choix possibles du menu
	public void printMenu(){
		System.out.println("1) Taper un mot avec les lettres "+mutualBag.getMutualBag());
		System.out.println("2) Passer son tour");
		System.out.println("3) Afficher la liste des mots");
	}
	
	
	//Menu d'actions en fonction du choix de l'utilisateur
	public int choiceAction(int i){
		int choice = 0;
		do{
			printMenu();
		
			if (sc.hasNextInt()) choice = sc.nextInt();
	        else {
	        	System.out.println("La valeur saisie n'est pas un entier!");
	            sc.next();
	            continue;
	        }

			switch(choice){
			case 1:
				System.out.println("Taper un mot : ");
				words.findWord(i, sc, mutualBag, tabPlayer, letterDraw);
				break;
			case 2: 
				//ALEXANDRE
				words.testStolenWord(tabPlayer);
				//FIN ALEXANDRE
				passTurn(i,tabPlayer);
				turnPlayer(tabPlayer);
				return choice;
				//break;
			case 3:
				System.out.println("Liste des mots : "+tabPlayer[i].listWord);
				
			}
		}while((choice != 1 || choice !=2 || choice !=3) && tabPlayer[i].score <10);
		System.out.println("Fin du game");
		return choice;
		
	}


	//Tri a bulle sur le tableau de joueur pour connaître celui à la plus petite lettre
	public Player[] sortArray(Player[] tabPlayer){
		int i,j;
		Player flag;
		
		for(i=0; i< tabPlayer.length; i++){
			for(j=1; j < tabPlayer.length; j++){
				if(tabPlayer[j-1].val > tabPlayer[j].val ){
					flag = tabPlayer[j];
					tabPlayer[j] = tabPlayer[j-1];
					tabPlayer[j-1] = flag;
				}
			}
		}
		return tabPlayer;
	}
	
	
}