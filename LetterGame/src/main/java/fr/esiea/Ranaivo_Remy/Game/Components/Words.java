package fr.esiea.Ranaivo_Remy.Game.Components;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.esiea.Ranaivo_Remy.Game.Core.IA;
import fr.esiea.Ranaivo_Remy.Game.Core.LetterDraw;

public class Words {

	IA ia = new IA();
	public Words(){}
	
	
	public static String removeAccent(String source) {
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
	
	
	
	/*public void stealingWord(Player player, String newWord){
		
		ArrayList<Character> tabOldChar = new ArrayList<Character>();
		ArrayList<Character> tabNewChar = new ArrayList<Character>();
		
		// INITIALISE TABNEWCHAR
		for (char c : newWord.toCharArray()) {
			  tabNewChar.add(c);
			}
		// FIN INITIALISE TABNEWCHAR
		
		for(int i=0; i<player.listWord.size(); i++){		
			
			// INITIALISE LE TABOLDCHAR
			for (char c : player.listWord.get(i).toCharArray()) {
			  tabOldChar.add(c);
			}
			// FIN INITIALISE TABOLDCHAR
			
			boolean flag = true;
			
			for(int j =0; j< tabNewChar.size(); j++){
				for(int k = 0; k < tabOldChar.size(); k++){
					System.out.println("Comparaison tabOldChar : "+tabOldChar.get(k)+ " et tabNewChar : "+tabNewChar.get(j));
					if(tabOldChar.get(k) == tabNewChar.get(j)){
						tabOldChar.remove(k);
						k--;
						break;
					}else if(k == tabOldChar.size()-1){
						flag = false;
					}
					
					
					if(flag == true){
						player.listWord.remove(i);
						player.score--;
					}
				}
				System.out.println("Test boolean : "+flag);
			}
	
			//TEST AFFICHAGE TABLEAU DES MOTS CREES
			//System.out.println("Tableau : "+tabOldChar[0]+" :: "+tabOldChar[1]);
			//FIN TEST
		}
	}*/
	
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
		Scanner file;
		ArrayList<Character> tmpPot = new ArrayList<Character>(pot.getMutualBag().size());
		tmpPot.addAll(pot.getMutualBag());
		
		if(target == null){
			System.out.println("Le joueur "+namePlayer+" n'existe pas");
			//TROUVER UN MOYEN DE QUITTER ET REVENIR AU MENU
		}
		else{
			System.out.println("Quel mot voulez vous voler ?");
			String wordToSteal = sc.next();
			wordToSteal = wordToSteal.toUpperCase();
			int idWordToSteal = whichWordStolen(target, wordToSteal);
			if(idWordToSteal == 20){
				System.out.println("Le joueur cible ne possède pas le mot "+wordToSteal);
			}
			else{
				System.out.println("Entrez votre nouveau mot formé à partir du mot "+wordToSteal+" :");
				String newWord = sc.next();
				newWord = newWord.toUpperCase();
				//System.out.println("new word : "+newWord);
				//System.out.println("stealing word : "+wordToSteal);
				
				if(newWord.contains(wordToSteal)){
					try {
						file = new Scanner(new File("C:/Users/Nora/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
					
						while(file.hasNextLine()){
							String line = file.nextLine().toUpperCase();
							line = removeAccent(line);
							int size = line.length();
							//System.out.println("lien"+line);
							//System.out.println("new word"+newWord);
							if(line.indexOf(newWord.toUpperCase()) != -1 && newWord.length() == size ){

								String diff = newWord.replace(wordToSteal, "");
								//System.out.println("diff"+diff);
								boolean supprOfMutualBag = pot.verifLetterMutualBag(diff, tmpPot);
								
								//System.out.println("Pot "+pot.getMutualBag());
								//System.out.println("Pot tempt"+tmpPot);
								//System.out.println("suppr"+supprOfMutualBag);
								val =1;
								
								if(supprOfMutualBag == true){
									System.out.println("Vol : ajouter le mot dans la liste");
									pot.getMutualBag().removeAll(pot.getMutualBag());
									pot.getMutualBag().addAll(tmpPot);
									target.listWord.remove(idWordToSteal); 
									target.score--;
									thief.score++;
									thief.listWord.add(newWord);
									//System.out.println("Score Joueur "+target.name+" : "+target.score);
									//System.out.println("Score Joueur "+thief.name+" : "+thief.score);
								}
							}else if(!file.hasNextLine()){
								if(val == 0)System.out.println("Le mot n'est pas dans le dico");
							}
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					System.out.println("Le mot n'est pas contenu");
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/*
	public void compareWord(List<String> listScoreWord, String word){
		for(int i=0; i<listScoreWord.size(); i++){
			boolean testCompare = word.startsWith(listScoreWord.get(i));
			//System.out.println(testCompare);
			if( testCompare == true) break;
		}
	}
	
	public void testStolenWord(Player[] tabPlayer){
		List<String> tabScoreWord = playerListScoreWord(tabPlayer);
		compareWord(tabScoreWord, "aa");
	}
*/
	public void findWord(int i, Scanner sc, MutualBag mutualBag, Player[] tabPlayer, LetterDraw letterDraw){
		String word = ""; 
		String iaList = "";
		if(tabPlayer[i].getIA()!=1){
		 word = sc.next();
	     word = removeAccent(word);
		}
		if(tabPlayer[i].getIA()==1){
			this.ia.setIaBag(mutualBag.getMutualBag());
			System.out.println("pot commun de l'IA : "+this.ia.getIaBag());
			for(Character iterator : this.ia.getIaBag()){
				iaList += iterator;
			}
			System.out.println(iaList);
		}
		int val = 0;
	       /**/
	        
	        Scanner file;
			try {
				file = new Scanner(new File("C:/Users/Kevin-R/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
				while(file.hasNextLine()){
					String line = file.nextLine().toUpperCase();
					line = removeAccent(line);
					int size = line.length();
					if (tabPlayer[i].getIA()==0){
					if(line.indexOf(word.toUpperCase()) != -1 && word.length() == size && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){
						tabPlayer[i].score++;
						tabPlayer[i].setListWord(tabPlayer[i].listWord);
						tabPlayer[i].listWord.add(line);
						System.out.println("Score de "+tabPlayer[i].name+" : "+tabPlayer[i].score);
			            val = 1;
			        	letterDraw.oneDraw(tabPlayer [i], mutualBag);
			        	}
					}
					else if(tabPlayer[i].getIA()==1){
					if(line.matches("["+iaList+"]+")==true && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){
						System.out.println();
						tabPlayer[i].score++;
						tabPlayer[i].setListWord(tabPlayer[i].listWord);
						tabPlayer[i].listWord.add(line);
						System.out.println("Score de "+tabPlayer[i].name+" : "+tabPlayer[i].score);
			            val = 1;
			        	letterDraw.oneDraw(tabPlayer [i], mutualBag);
						}
					}
			     }
			        if(val == 0) System.out.println("Le mot n'est pas valide");
			            
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}     
	    }
}
