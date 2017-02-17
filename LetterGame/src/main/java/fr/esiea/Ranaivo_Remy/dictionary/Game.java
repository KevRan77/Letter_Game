package fr.esiea.Ranaivo_Remy.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
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
	
	// *****  MÃ©thodes ***** \\
	
	//Methode Game qui lance la premiÃ¨re partie du jeu
	public Game(){
		
		Alphabet[] alphabet = Alphabet.values();
		Alphabet[] alphabet2 = new Alphabet[numberPlayer];
		
		startGame(alphabet, alphabet2 );
	}
	
	//Affiche le nombre de joueurs
	public void getChoiceNbPlayer(){
		System.out.print(this.choiceNbPlayer);
	}
	
	//RÃ©cupÃ¨re un entier entrÃ© au clavier (nombre de joueurs)
	public int getInt(){
		return this.keyEnter = sc.nextInt();
	}
	
	//RÃ©cupÃ¨re un mot Ã©cris au clavier (nom du joueur)
	public String getString(){
		return sc.next();
	}
	
	//Permet Ã  l'utilisateur d'entrer le nombre de joueur pour la partie
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
	
	//RÃ©cuÃ¨pre le nom de chaque joueur et stocke dans un tableau
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
	
	//Attribut une lettre alÃ©atoire aux joueurs et remplit ces lettres dans le pot commun
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
					alphabet[j].setChar('0');
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
		Player player = whoStart(this.tabPlayer);
		printMutualBag();
		playerStarterDraw(player);
		//String word = sc.next();
		//turnPlayer(this.tabPlayer);
		//System.out.println(verifLetterMutualBag(word, this.potCommun));
		findWord();
	}
	
	//Affiche quel est le joueur qui commence
	public Player whoStart(Player[] tabPlayer){
		tabPlayer = sortArray(tabPlayer);
		tabPlayer[0].play = true;
		System.out.println("Le joueur "+tabPlayer[0].name+" commence.");
		return tabPlayer[0];
	}
	
	public void turnPlayer(Player[] tabPlayer){
		
		for(int i = 0; i < tabPlayer.length; i++){
			if(tabPlayer[i].play == true){
				System.out.println(tabPlayer[i].name+" joue");
				int choice = choiceAction();
				if(choice ==2){
					passTurn(i,tabPlayer);
					turnPlayer(tabPlayer);
				}
			}
		}
		
	}
	
	public static String removeAccent(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
	
	
	public void findWord(){
		String word = ""; 
		int val = 0;
	        word = sc.next();
	        word = removeAccent(word);
	        System.out.println(word);
	        Scanner file;
			try {
				file = new Scanner(new File("C:/Users/Nora/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
				while(file.hasNextLine()){
					String line = file.nextLine().toUpperCase();
					line = removeAccent(line);
					int size = line.length();
					if(line.indexOf(word.toUpperCase()) != -1 && word.length() == size && verifLetterMutualBag(line,this.potCommun) == true){
						System.out.println("Le mot est dans le dico et utilise les lettres du pot commun");
			            val = 1;
			            break;
			        }
			     }
			        if(val == 0){
			            System.out.println("Le mot n'est pas dans le dico");
			        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}      
	    }
	
	
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
	
	public int choiceAction(){
		int choice;
		System.out.println("1) Taper un mot");
		System.out.println("2) Passer son tour");
		 
		//do{
			choice = sc.nextInt();
		//}while(choice != 1 || choice !=2);
		
		return choice;
		
	}
	
	public Boolean verifLetterMutualBag(String word, ArrayList<Character> potCommun){
		//Boolean flag = false;
		char[] tabChar;
		tabChar = word.toCharArray();
		
		for(int i =0; i< tabChar.length; i++){
			for(int j = 0; j < potCommun.size(); j++){
				if(tabChar[i] == potCommun.get(j)){
					potCommun.remove(j);
					j--;
					break;
				}else if(j == potCommun.size()-1){
					return false;
				}
			}
		}
		
		return true;
	}
	
	//Tri a bulle sur le tableau de joueur pour connaÃ®tre celui Ã  la plus petite lettre
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
	
	//Ajout de lettre dans le pot commun
	public void mutualBag(char letter){
			this.potCommun.add(letter); 
		}
}