package fr.esiea.Ranaivo_Remy.Game.Core;

import java.util.Scanner;

import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Components.Words;
import fr.esiea.Ranaivo_Remy.Game.Interface.IGame;

public class Game implements IGame {
	// *****  Variables  ***** \\
	int keyEnter, numberPlayer, gameMode;
	
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
	public int setNbPlayer(){
		do{
			System.out.println("1) Joueur vs Joueur");
			System.out.println("2) Joueur vs IA");
			if(sc.hasNextInt()) this.gameMode = sc.nextInt();
			/* gameMode c'est le mode de la Partie (Joueur vs Joueur ou Joueur vs IA) */
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
			}
			
			this.tabPlayer = new Player[this.numberPlayer];
		}while(numberPlayer < 2 || (gameMode != 1 && gameMode !=2) );
		
		return gameMode;
	}
	

	//Initialise le tableau de joueur avec des joueurs "null"
	public void initTabPlayer(int gameMode){
		for(int i = 0; i<this.numberPlayer; i++){
			this.tabPlayer[i] = new Player();
			if(gameMode == 2 && i == 1)this.tabPlayer[i].setIA(1);
			this.tabPlayer[i].listWord.remove("null");
		}
	}
	
	//Initialise le pot commun
	public void initMutualBag(){
		this.mutualBag.getMutualBag().remove(null);
	}
	
	//Récupère le nom de chaque joueur et stocke dans un tableau
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
			else if(j == 2 && iterator.getIA()==0){
			System.out.println("Entrez votre nom : ");
			iterator.setName(getString());
			}
			else{
			i++;
			System.out.println("Entrez le nom du Joueur "+i+" :" );
			iterator.setName(getString());
			}
		}
	}
	
	public void printWordPlayer(Player[] tabPlayer){
		System.out.println("\n***************************");
		for(Player i : this.tabPlayer){
			System.out.println("Mots du joueur "+i.getName()+" : "+i.getListWord()+" et score : "+i.getScore());
		}
		System.out.println("***************************\n");
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
		tabPlayer[0].setPlay(true);
		System.out.println("Le joueur "+tabPlayer[0].getName()+" commence.");
		return tabPlayer[0];
	}
	
	//Permet au joueur de jouer 
	public void turnPlayer(Player[] tabPlayer){	
		for(int i = 0; i < tabPlayer.length; i++){
			if(tabPlayer[i].getPlay() == true/* && tabPlayer[i].getScore() <10*/){
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
			//if(this.tabPlayer[1].getIA() == 1 && this.tabPlayer[1].getPlay() == true)break;
			
			printWordPlayer( this.tabPlayer);
			printMenu();
			System.out.println(i);
			System.out.println(this.tabPlayer[i].getIA());
			
			if(this.tabPlayer[i].getIA()==1)choice = 2;
			else if (this.tabPlayer[i].getIA()==0 && sc.hasNextInt())choice = sc.nextInt();
			else if(!sc.hasNextInt()){
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
				//
				//words.stealingWord(tabPlayer[0], "TUTU");
			
				
				//ALEXANDRE
				//words.testStolenWord(tabPlayer);
				//FIN ALEXANDRE
				passTurn(i,tabPlayer);
				turnPlayer(tabPlayer);	
				
				return choice;
				//break;
			case 3: 
				boolean playerPlaying = tabPlayer[i].getPlay();
				Player player = new Player();
				
				for(int j=0; j < tabPlayer.length; j++){
					
					if(playerPlaying == true){
						player = tabPlayer[i];
					}
				}
				words.stealingWord(tabPlayer, mutualBag, player);
				
				/*String word = ""; 
				String word2 = "";
				int val = 0;
			        word = sc.next();
			       // word = removeAccent(word);
			       word2 = sc.next();
			       // word2 = removeAccent(word2);
			        System.out.println(word2.endsWith(word));
			        String[] tokens = word2.split(word);
			        String newWord = "null";
			        
			        for (int a = 0; a < tokens.length; a++){
			            System.out.println("letttre split "+tokens[a]);
			        	newWord = new String(tokens[a]).toUpperCase();
			        }
			        System.out.println(newWord);*/
			
			break;
				}
				
		}while((choice != 1 || choice !=2 || choice != 3) && tabPlayer[i].getScore() <10);
		System.out.println("Fin du game");
		return choice;
		
	}

	//Tri a bulle sur le tableau de joueur pour connaître celui à la plus petite lettre
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

	public void initTabPlayer() {
		// TODO Auto-generated method stub
		
	}
	
	
}