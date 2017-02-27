package fr.esiea.Ranaivo_Remy.Game.Components;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.esiea.Ranaivo_Remy.Game.Core.LetterDraw;

public class Words {

	public Words(){}
	

	public String removeAccent(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
	}
	
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


	public int whichWordStolen(Player player, String sameWord){
		int idWord = 20;
		for(int i = 0; i < player.listWord.size(); i++){
			if(player.listWord.get(i).equals(sameWord)){
				idWord = i;
			}
		}
		return idWord;
	}
	
	public Player whoIsStolen(Player[] tabPlayer, String namePlayer){
		Player target = null;
		for(int i = 0; i < tabPlayer.length; i++){
			if(namePlayer.equals(tabPlayer[i].getName())){
				target  = tabPlayer[i];
			}
		}
		return target;
	}

	public void stealingWord(Player[] tabPlayer, MutualBag pot, Player thief){
		System.out.println("A quel joueur voulez vous voler un mot ?");
		Scanner sc = new Scanner(System.in);
		int val =0;
		String namePlayer = sc.next();
		Player target = new Player();
		target = whoIsStolen(tabPlayer, namePlayer);
		ArrayList<Character> tmpPot = new ArrayList<Character>(pot.getMutualBag().size());
		tmpPot.addAll(pot.getMutualBag());
		
		if(target == null){
			System.out.println("Le joueur "+namePlayer+" n'existe pas");
			//TROUVER UN MOYEN DE QUITTER ET REVENIR AU MENU
		}
		else{
			whichWordToSteal(sc,target,pot,tmpPot,thief,val);
		}
	}
	
	public void whichWordToSteal(Scanner sc, Player target,MutualBag pot, ArrayList<Character> tmpPot, Player thief, int val ){
		System.out.println("Quel mot voulez vous voler ?");
		String wordToSteal = sc.next();
		wordToSteal = wordToSteal.toUpperCase();
		int idWordToSteal = whichWordStolen(target, wordToSteal);
		
		if(idWordToSteal == 20){
			System.out.println("Le joueur cible ne possède pas le mot "+wordToSteal);
		}
		else{
			newWord(sc,wordToSteal,pot,tmpPot,target,thief,idWordToSteal,val);
		}
	}
	
	public void newWord(Scanner sc, String wordToSteal,MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, int idWordToSteal, int val){
		Scanner file;
		System.out.println("Entrez votre nouveau mot formé à partir du mot "+wordToSteal+" :");
		String newWord = sc.next();
		newWord = newWord.toUpperCase();
		
		if(newWord.contains(wordToSteal) && newWord.length() > wordToSteal.length()){
			try {
				file = new Scanner(new File("C:/Users/Nora/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
				searchInDico(file,newWord,wordToSteal,pot,tmpPot,target,thief,idWordToSteal,val);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Erreur : Le mot n'est pas valide");
		}
	}
	
	public void searchInDico(Scanner file, String newWord, String wordToSteal,MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, int idWordToSteal, int val ){
		
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
	
	
	public void succeedTheft(MutualBag pot, ArrayList<Character> tmpPot, Player target, Player thief, String newWord, int idWordToSteal ){
		System.out.println("Vol : ajout du mot dans la liste");
		pot.getMutualBag().removeAll(pot.getMutualBag());
		pot.getMutualBag().addAll(tmpPot);
		target.listWord.remove(idWordToSteal); 
		target.score--;
		thief.score++;
		thief.listWord.add(newWord);
	}
	
	

	public void findWord(int i, Scanner sc, MutualBag mutualBag, Player[] tabPlayer, LetterDraw letterDraw){
		String word = ""; 
		int val = 0;
	    word = sc.next();
	    word = removeAccent(word);
	    Scanner file;
			
	    try {
				file = new Scanner(new File("C:/Users/Nora/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
				searchInDicoBasic(file,word,mutualBag,i,tabPlayer,val,letterDraw);
			            
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}			
	}
	
	
	public void searchInDicoBasic(Scanner file, String word, MutualBag mutualBag, int i, Player[] tabPlayer, int val,LetterDraw letterDraw){
		while(file.hasNextLine()){
			String line = file.nextLine().toUpperCase();
			line = removeAccent(line);
			int size = line.length();
			if(line.indexOf(word.toUpperCase()) != -1 && word.length() == size && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){						
				statPlayer(i,tabPlayer,line);
	            val = 1;  
	        	letterDraw.oneDraw(tabPlayer [i], mutualBag);
	        }
	     }
	        if(val == 0) System.out.println("Le mot n'est pas valide");
	}
	
	public void statPlayer(int i, Player[] tabPlayer, String line){
		tabPlayer[i].score++;
		tabPlayer[i].setListWord(tabPlayer[i].listWord);
		tabPlayer[i].listWord.add(line);
		System.out.println("Score de "+tabPlayer[i].name+" : "+tabPlayer[i].score);
	}
	
}
