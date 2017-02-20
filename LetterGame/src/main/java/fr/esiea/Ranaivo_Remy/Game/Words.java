package fr.esiea.Ranaivo_Remy.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Words {

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

	public void findWord(int i, Scanner sc, MutualBag mutualBag, Player[] tabPlayer, LetterDraw letterDraw){
		String word = ""; 
		//String word2 = "";
		int val = 0;
	        word = sc.next();
	        word = removeAccent(word);
	      /*  word2 = sc.next();
	        word2 = removeAccent(word2);
	        System.out.println(word2.endsWith(word));
	        String[] tokens = word2.split(word);
	        String newWord = "null";
	        
	        for (int a = 0; a < tokens.length; a++){
	            System.out.println(tokens[a]);
	        	newWord = new String(tokens[a]).toUpperCase();
	        }
	        System.out.println(newWord);
	        System.out.println(verifLetterMutualBag(newWord,this.potCommun));*/
	        
	        Scanner file;
			try {
				file = new Scanner(new File("C:/Users/Nora/git/Letter_Game/LetterGame/src/main/resources/dico.txt"));
				while(file.hasNextLine()){
					String line = file.nextLine().toUpperCase();
					line = removeAccent(line);
					int size = line.length();
				//	if(word.length() ){}
					//tabPlayer[i].setListWord(tabPlayer[i].listWord);
				/*	for(int j = 0 ; j < numberPlayer; j++){
						for(int count = 0; count < tabPlayer[j].listWord.size(); count++ ){
							//int lastElement = tabPlayer[i].listWord.size() - 1;
							String wordCompare = tabPlayer[j].getListWord().get(count);
							//String wordWritten = tabPlayer[i].getListWord().get(lastElement);
							Boolean resultOfCompare = word.startsWith(wordCompare);
							System.out.println("result of compare : "+resultOfCompare);
							if(resultOfCompare == true && word.length() > wordCompare.length()){
								
								stealingWord(tabPlayer, word, wordCompare, count, j, i);
								
							}
						}
					}	*/
					

					if(line.indexOf(word.toUpperCase()) != -1 && word.length() == size && mutualBag.verifLetterMutualBag(line,mutualBag.getMutualBag()) == true){
						tabPlayer[i].score++;
						tabPlayer[i].setListWord(tabPlayer[i].listWord);
						tabPlayer[i].listWord.add(line);
						//System.out.println("list : "+tabPlayer[i].listWord);
						System.out.println("Score de "+tabPlayer[i].name+" : "+tabPlayer[i].score);
			            val = 1;  
			        	letterDraw.oneDraw(tabPlayer [i], mutualBag);
			        }
			     }
			        if(val == 0) System.out.println("Le mot n'est pas valide");
			            
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}     
	    }
}
