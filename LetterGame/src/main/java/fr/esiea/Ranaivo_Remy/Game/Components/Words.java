package fr.esiea.Ranaivo_Remy.Game.Components;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fr.esiea.Ranaivo_Remy.Game.Core.IA;
import fr.esiea.Ranaivo_Remy.Game.Core.LetterDraw;

public class Words {

	IA ia = new IA();
	
	public Words(){}

	//Méthode pour enlever les accents
	public String removeAccent(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
	
	//Méthode qui retourne un tableau des scores des joueurs
	public List<String> playerListScoreWord(Player[] tabPlayer){
		List<String> tabScoreWord = new ArrayList<String>();
		for(int i=0; i<tabPlayer.length; i++){
			for(int j=0; j<tabPlayer[i].listWord.size(); j++){
				tabScoreWord.add(tabPlayer[i].listWord.get(j));
				System.out.println(tabScoreWord.get(j));
			}
			System.out.println("\n");
		}
		return tabScoreWord;
	}

	//Méthode qui retourne le mot que l'on souhaite voler
	public int whichWordStolen(Player player, String sameWord){
		int idWord = 20;
		for(int i = 0; i < player.listWord.size(); i++){
			if(player.listWord.get(i).equals(sameWord)){
				idWord = i;
			}
		}
		return idWord;
	}

	//Méthode qui retourne le joueur que l'on souhaite voler
	public Player whoIsStolen(Player[] tabPlayer, String namePlayer){
		Player target = null;
		for(int i = 0; i < tabPlayer.length; i++){
			if(namePlayer.equals(tabPlayer[i].getName())){
				target  = tabPlayer[i];
			}
		}
		return target;
	}

	//Methode qui vole un mot
	public void stealingWord(Player[] tabPlayer, MutualBag pot, Player thief){
		System.out.println("A quel joueur voulez vous voler un mot ?");
		Scanner sc = new Scanner(System.in);
		String namePlayer = sc.next();
		Player target = new Player();
		target = whoIsStolen(tabPlayer, namePlayer);
		ArrayList<Character> tmpPot = new ArrayList<Character>(pot.getMutualBag().size());
		tmpPot.addAll(pot.getMutualBag());
		
		if(target == null){
			System.out.println("Le joueur "+namePlayer+" n'existe pas");
		}
		else{
			whichWordToSteal(sc,target,pot,tmpPot,thief);
		}
	}
	
	//Methode qui indique quel mot est à voler
	public void whichWordToSteal(Scanner sc, Player target,MutualBag pot, ArrayList<Character> tmpPot, Player thief){
		System.out.println("Quel mot voulez vous voler ?");
		String wordToSteal = sc.next();
		wordToSteal = wordToSteal.toUpperCase();
		int idWordToSteal = whichWordStolen(target, wordToSteal);
		
		if(idWordToSteal == 20){
			System.out.println("Le joueur cible ne possède pas le mot "+wordToSteal);
		}
		else{
			newWord(sc,wordToSteal,pot,tmpPot,target,thief,idWordToSteal);
		}
	}
	
	//Méthode qui valide le nouveau mot 
	public void newWord(Scanner sc, String wordToSteal,MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, int idWordToSteal){
		Scanner file;
		System.out.println("Entrez votre nouveau mot formé à  partir du mot "+wordToSteal+" :");
		String newWord = sc.next();
		newWord = newWord.toUpperCase();
		
		if(newWord.contains(wordToSteal) && newWord.length() > wordToSteal.length()){
			try {

				File currentDirFile = new File("src/main/resources/dico.txt");
		    	String helper = currentDirFile.getAbsolutePath();
				file = new Scanner(new File(helper));
				searchInDico(file,newWord,wordToSteal,pot,tmpPot,target,thief,idWordToSteal);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Erreur : Le mot n'est pas valide");
		}
	}
	
	//Méthode qui vérifie que le mot est présent dans le dictionnaire
	public void searchInDico(Scanner file, String newWord, String wordToSteal,MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, int idWordToSteal){
		int val =0;
		while(file.hasNextLine()){
			String line = file.nextLine().toUpperCase();
			line = removeAccent(line);
			int size = line.length();
			if(line.indexOf(newWord.toUpperCase()) != -1 && newWord.length() == size ){
				String diff = newWord.replace(wordToSteal, "");
				boolean supprOfMutualBag = pot.verifLetterMutualBag(diff, tmpPot);
				val =1;
				
				if(supprOfMutualBag == true) succeedTheft(pot,tmpPot,target, thief,newWord,idWordToSteal);		
			}else if(!file.hasNextLine()){
				if(val == 0) System.out.println("Le mot n'est pas dans le dico");
			}
		}
	}
	
	//Méthode qui valide le vol et change les caractéristiques des deux joueurs
	public void succeedTheft(MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, String newWord, int idWordToSteal ){
		System.out.println("Vol : ajout du mot dans la liste");
		pot.getMutualBag().removeAll(pot.getMutualBag());
		pot.getMutualBag().addAll(tmpPot);
		target.listWord.remove(idWordToSteal); 
		target.score--;
		thief.score++;
		thief.listWord.add(newWord);
	}
	
	//Méthode qui vérifie si le mot est valide ou pas
	public void findWord(int i, Scanner sc, MutualBag mutualBag, Player[] tabPlayer, LetterDraw letterDraw){
		String word = ""; 
		String iaList = "";
		int val = 0;
	    Scanner file;
	    try {
	    	File currentDirFile = new File("src/main/resources/dico.txt");
	    	String helper = currentDirFile.getAbsolutePath();
				file = new Scanner(new File(helper));
				if(tabPlayer[i].getIA()!=1){
				    word = sc.next();
				    word = removeAccent(word);
				    searchInDicoBasic(file,word,mutualBag,i,tabPlayer,val,letterDraw);
				}
				//C'est ici que l'IA entre en jeu : on initialise le potCommun de l'IA et on concatÃ¨ne chaque lettre du potCommun dans un String (iaList)
				if(tabPlayer[i].getIA()==1){
					this.ia.setIaBag(mutualBag.getMutualBag());
					for(Character iterator : this.ia.getIaBag()){
						iaList += iterator;
					}
					searchInDicoIA(iaList, file, mutualBag,  i,  tabPlayer, letterDraw);
				}			            
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}			
	}
	
	//Méthode qui permet de parcourir le dico
	public void searchInDicoBasic(Scanner file, String word, MutualBag mutualBag, int i, Player[] tabPlayer, int val,LetterDraw letterDraw){
		while(file.hasNextLine()){
			String line = file.nextLine().toUpperCase();
			line = removeAccent(line);
			int size = line.length();
			if(line.indexOf(word.toUpperCase()) != -1 && word.length() == size && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){						
				statPlayer(i,tabPlayer,line);
	            val = 1;  

	            if(tabPlayer[i].getScore() < 10)letterDraw.oneDraw(tabPlayer[i], mutualBag);

	            if(tabPlayer[i].getScore() < 5)letterDraw.oneDraw(tabPlayer[i], mutualBag);
	        }
	     }
	        if(val == 0) System.out.println("Le mot n'est pas valide");
	}
	
	//Méthode de l'IA qui va chercher tous les mots du dico similaires à  "iaList", iaList représentant le potCommun mais en STRING
	public void searchInDicoIA(String iaList, Scanner file, MutualBag mutualBag, int i, Player[] tabPlayer,LetterDraw letterDraw){
		while(file.hasNextLine() && tabPlayer[i].getScore() < 5){
			String line = file.nextLine().toUpperCase();
			line = removeAccent(line);
			//c'est l'expression régulière utilisée dans le "if" qui gère le fait de pouvoir matcher iaList avec les mots du dico.
		if(line.matches("["+iaList+"]+")==true && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){
			System.out.println(line);
			statPlayer(i, tabPlayer,line);
            if(tabPlayer[i].getScore() < 5) letterDraw.oneDraw(tabPlayer[i], mutualBag);
			}
		}
		tabPlayer[i].setPlay(false);
	}
	
	//Méthode qui change les charactéristiques du joueur (score, liste de mot)
	public void statPlayer(int i, Player[] tabPlayer, String line){
		tabPlayer[i].score++;
		tabPlayer[i].setListWord(tabPlayer[i].listWord);
		tabPlayer[i].listWord.add(line);
		System.out.println("Score de "+tabPlayer[i].name+" : "+tabPlayer[i].score);
	}
	
}
