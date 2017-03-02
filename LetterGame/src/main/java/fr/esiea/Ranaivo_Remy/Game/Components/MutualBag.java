package fr.esiea.Ranaivo_Remy.Game.Components;

import java.util.ArrayList;

public class MutualBag {
	ArrayList<Character> mutualBag = new ArrayList<Character>();
	 //Singleton
    private static MutualBag instanceMutualBag = new MutualBag();
	
    //Ajout d'un élément null à mutualbag
	public MutualBag(){
		this.mutualBag.add(null);
	}
	
	//Singleton
	public static MutualBag getInstanceMutualBag() { 
		return instanceMutualBag; 
	}
	
	//Getter MutualBag
	public ArrayList<Character> getMutualBag(){
		return this.mutualBag;
	}
	
	//Setter MutualBag
	public void setMutualBag(ArrayList<Character> mutualBag){
		this.mutualBag = mutualBag;
	}
	
	//Ajout de lettre dans le pot commun
	public void mutualBagAddLetter(char letter){
			this.mutualBag.add(letter); 
	}
	
	//Vérification des lettres présentes ou non dans le pot commun
	public Boolean verifLetterMutualBag(String word, ArrayList<Character> mutualBag){
		char[] tabChar;
		boolean flag = true;
		tabChar = word.toCharArray();
		ArrayList<Character> tmpPotCommun = new ArrayList<Character>(mutualBag.size());
		tmpPotCommun.addAll(mutualBag);
			
		for(int i =0; i< tabChar.length; i++){
			for(int j = 0; j < tmpPotCommun.size(); j++){
				if(tabChar[i] == tmpPotCommun.get(j)){
					tmpPotCommun.remove(j);
					j--;
					break;
				}else if(j == tmpPotCommun.size()-1){
					flag = false;
				}
			}
		}
		if(flag == true){
			mutualBag.removeAll(mutualBag);
			mutualBag.addAll(tmpPotCommun);
		}
		return flag;
	}
		

	//Affiche le contenu du pot commun
	public void printMutualBag(){
		System.out.println("Pot commun : "+this.mutualBag);
	}

}
