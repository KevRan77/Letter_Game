package fr.esiea.Ranaivo_Remy.Game.Core;

import java.util.Scanner;
import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Components.Words;
import fr.esiea.Ranaivo_Remy.Game.Interface.IGame;

public class Game implements IGame {
	// *****  Variables  ***** \\
	int keyEnter, gameMode;
	int numberPlayer = 0;
	IA ia = new IA();
	
	Player[] tabPlayer = new Player[numberPlayer];
	String[] playerName = new String[numberPlayer];
	
	//Singleton
	MutualBag mutualBag = MutualBag.getInstanceMutualBag();
	LetterDraw letterDraw = new LetterDraw();
	Words words = new Words();
	
	Scanner sc = new Scanner(System.in);
	
	// *****  Methodes ***** \\
	
	//Methode Game qui lance la premiere partie du jeu
	public Game(){
		Alphabet[] alphabet = Alphabet.values();
		startGame(alphabet);
	}
	
	//Recupere un mot ecris au clavier (nom du joueur)
	public String getString(){
		return sc.next();
	}
	
	//Permet a l'utilisateur d'entrer le nombre de joueur pour la partie
	public int setNbPlayer(){
		do{
			System.out.println("1) Joueur vs Joueur");
			System.out.println("2) Joueur vs IA");
			if(sc.hasNextInt()) this.gameMode = sc.nextInt();
			/* gameMode c'est le mode de la Partie (1) Joueur vs Joueur ou 2) Joueur vs IA) */
			else {
	        	System.out.println("La valeur saisie n'est pas un entier!");
	            sc.next();
	            continue;
	        }
			if(gameMode == 1){
				System.out.println("Veuillez entrer le nombre de joueurs, minimum 2 : ");
				if (sc.hasNextInt()) this.numberPlayer = sc.nextInt();
		        else {
		        	System.out.println("La valeur saisie n'est pas un entier!");
		            sc.next();
		            continue;
		        }
			}
			else if(gameMode == 2){
				this.numberPlayer = 2;
				this.ia.iaMode = 1;
			}

			this.tabPlayer = new Player[this.numberPlayer];
		}while(numberPlayer < 2 || (gameMode != 1 && gameMode !=2) );
		
		return gameMode;
	}
	

	//Initialise le tableau de joueur avec des joueurs "null"
	public void initTabPlayer(int gameMode){
		for(int i = 0; i<this.numberPlayer; i++){
			this.tabPlayer[i] = new Player();
		//on attribue d'office la valeur 1 pour l'IA dans le cas ou on est dans le mode Joueur vs IA histoire de les différencier
			if(gameMode == 2 && i == 1)this.tabPlayer[i].setIA(1);
			this.tabPlayer[i].listWord.remove("null");
		}
	}
	
	//Initialise le pot commun
	public void initMutualBag(){
		this.mutualBag.getMutualBag().remove(null);
	}
	
	//Recupere le nom de chaque joueur et stocke dans un tableau
	public void setNameEnter(){
		int j = 0;
		int i = 0;
		j = setNbPlayer();
		initTabPlayer(j);
		initMutualBag();
		
		//Design Pattern : iterator
		for(Player iterator : this.tabPlayer){
			if(iterator.getIA()==1 && j == 2){
				iterator.setName("IA");
				break;	
			}
			//Ajustement du menu pour le mode Joueur vs IA
			else if(j == 2 && iterator.getIA()==0){

				System.out.println("Entrez votre nom : ");
				iterator.setName(getString());
			}
			else{
				//Ajout du numéro des joueurs (esthétisme)
				i++;
				System.out.println("Entrez le nom du Joueur "+i+" :" );
				iterator.setName(getString());
			}
		}
	}
	
	//Affiche les mots et score des joueurs
	public void printWordPlayer(Player[] tabPlayer){
		System.out.println("\n***************************");
		for(Player i : this.tabPlayer){
			System.out.println("Mots de "+i.getName()+" : "+i.getListWord()+" et score : "+i.getScore());
		}
		System.out.println("***************************\n");
	}
	

	//Regroupement des fonctions pour lancer le jeu
	public void startGame(Alphabet[] alphabet){
		setNameEnter();
		letterDraw.firstDraw(this.tabPlayer, alphabet, mutualBag);
		whoStart(this.tabPlayer);
		mutualBag.printMutualBag();
		turnPlayer(this.tabPlayer);
	}
	
	//Affiche quel est le joueur qui commence
	public Player whoStart(Player[] tabPlayer){
		tabPlayer = sortArray(tabPlayer);
		tabPlayer[0].setPlay(true);
		System.out.println(tabPlayer[0].getName()+" commence.");
		return tabPlayer[0];
	}
	
	//Permet au joueur de jouer 
	public void turnPlayer(Player[] tabPlayer){	
		for(int i = 0; i < tabPlayer.length; i++){
			if(tabPlayer[i].getPlay() == true && tabPlayer[i].getScore() <5){
				System.out.println(tabPlayer[i].getName()+" joue");
				letterDraw.playerStarterDraw(tabPlayer[i], mutualBag);
				choiceAction(i);
			}
		}
	}	
	
	//Passe le tour du joueur
	public void passTurn(int idPlayer, Player[] tabPlayer){
		if(tabPlayer.length-1 == idPlayer){
			tabPlayer[idPlayer].setPlay(false);
			tabPlayer[0].setPlay(true);
		}
		else{
			tabPlayer[idPlayer].setPlay(false);
			tabPlayer[idPlayer+1].setPlay(true);
		}
	}
	
	//Affiche les choix possibles du menu
	public void printMenu(){
		System.out.println("1) Taper un mot avec les lettres "+mutualBag.getMutualBag());
		System.out.println("2) Passer son tour");
		System.out.println("3) Voler un mot");
	}
	
	
	//Menu d'actions en fonction du choix de l'utilisateur
	public int choiceAction(int i){
		int choice = 0;
		do{
			if(tabPlayer[i].getIA() == 1) ia.iaMode = 1;
			if(tabPlayer[i].getIA() == 0){
				ia.iaMode = 0; printWordPlayer(this.tabPlayer); 
				printMenu();
				}			
			if(ia.iaMode == 1){
				if(tabPlayer[i].getIA()== 1 && tabPlayer[i].getPlay() == true)	choice = 1;
				if(tabPlayer[i].getIA() == 1 && tabPlayer[i].getPlay() == false){
					choice = 2; 
					ia.iaMode = 0;
				}	
			}
			
			else if(ia.iaMode == 0 && sc.hasNextInt())choice = sc.nextInt();
			else{
	        	System.out.println("La valeur saisie n'est pas un entier!");
	            sc.next();
	            continue;
	        }

			switch(choice){
			case 1:
				System.out.println("Taper un mot : ");
				words.findWord(i, sc, mutualBag,tabPlayer, letterDraw);
				break;
			case 2: 
				passTurn(i,tabPlayer);
				turnPlayer(tabPlayer);	
				return choice;
			case 3: 
				boolean playerPlaying = tabPlayer[i].getPlay();
				Player player = new Player();
				
				for(int j=0; j < tabPlayer.length; j++){
					if(playerPlaying == true){
						player =tabPlayer[i];
					}
				}
				words.stealingWord(tabPlayer, mutualBag, player);
				break;
				}
				
		}while((choice != 1 || choice != 3) && this.tabPlayer[i].getScore() <5);
		printWordPlayer(this.tabPlayer);
		System.out.println("Fin du game");
		System.out.println("Victoire de "+tabPlayer[i].getName()+" !");
		return choice;
	}

	//Tri a bulle sur le tableau de joueur pour connaitre celui a la plus petite lettre
	public Player[] sortArray(Player[] tabPlayer){
		int i,j;
		Player flag;
		
		for(i=0; i< tabPlayer.length; i++){
			for(j=1; j < tabPlayer.length; j++){
				if(tabPlayer[j-1].getVal() > tabPlayer[j].getVal() ){
					flag = tabPlayer[j];
					tabPlayer[j] = tabPlayer[j-1];
					tabPlayer[j-1] = flag;
				}
			}
		}
		return tabPlayer;
	}

	
}