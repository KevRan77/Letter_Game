package fr.esiea.Ranaivo_Remy.Game.Components;

import java.util.ArrayList;

public class MutualBag {
	ArrayList<Character> mutualBag = new ArrayList<Character>();
	 //Singleton
    private static MutualBag instanceMutualBag = new MutualBag();
	
	public MutualBag(){
		this.mutualBag.add(null);
	}
	
	//Singleton
	public static MutualBag getInstanceMutualBag() { return instanceMutualBag; }
	
	public ArrayList<Character> getMutualBag(){
		return this.mutualBag;
	}
	
	public void setMutualBag(ArrayList<Character> mutualBag){
		this.mutualBag = mutualBag;
	}
	
	//Ajout de lettre dans le pot commun
	public void mutualBagAddLetter(char letter){
			this.mutualBag.add(letter); 
	}
	
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
			//potCommun = tmpPotCommun;
		//	System.out.println("pot commun test :"+mutualBag);
		//	System.out.println(tmpPotCommun);
			return flag;
		}
		

	//Affiche le contenu du pot commun
		public void printMutualBag(){
			System.out.println("Pot commun : "+this.mutualBag);
		}
	
	
		
		/*	 
		public void sortTabIndex(int[] tabIndex){
			int i,j;
			int flag;
			
			for(i=0; i< tabIndex.length; i++){
				for(j=1; j < tabIndex.length; j++){
					if(tabIndex[j-1] < tabIndex[j] ){
						flag = tabIndex[j];
						tabIndex[j] = tabIndex[j-1];
						tabIndex[j-1] = flag;
					}
				}
			}
		}
		*/	
		
	/*
	 * 	
	 public static boolean findDoublon(final int[] tabIndex)
	  	{
	      for (int i = 0; i < tabIndex.length; i++)
	      {
	          for (int j = 0; j < i; j++) {
	              final Object o1 = tabIndex[i];
	              final Object o2 = tabIndex[j];
	              if (o1 != null && o2 != null) {
	                  if (o1.equals(o2)) return true;
	              }
	          }
	      }
	      return false;
	  }
	 
	 public static boolean findDoublon(final char[] tabIndex)
	  	{
	      for (int i = 0; i < tabIndex.length; i++)
	      {
	          for (int j = 0; j < i; j++) {
	              final Object o1 = tabIndex[i];
	              final Object o2 = tabIndex[j];
	              if (o1 != null && o2 != null) {
	                  if (o1.equals(o2)) return true;
	              }
	          }
	      }
	      return false;
	  }
	 
	 public static boolean findDoublon(final ArrayList<Character> tabIndex, char letter)
	  	{
	      for (int i = 0; i < tabIndex.size(); i++)
	      {
	          for (int j = 0; j < i; j++) {
	              final Object o1 = tabIndex.get(i);
	              final Object o2 = tabIndex.get(j);
	              if (o1 != null && o2 != null) {
	                  if (o1.equals(o2) && o1.equals(letter)) return true;
	              }
	          }
	      }
	      return false;
	  }
	  
	  
	  
	  public Boolean verifLetterMutualBag(String word, ArrayList<Character> potCommun){
	 
		char[] tabChar;
		word = word.toUpperCase();
		tabChar = word.toCharArray();		
		int index = 0;
		int[] tabIndex = new int[tabChar.length];
		int[] tabDoublon = new int[potCommun.size()];
		
		
		for(int i =0; i< tabChar.length; i++){
			for(int j =0; j < potCommun.size(); j++){
				
				if(findDoublon(tabChar) == true && findDoublon(potCommun,tabChar[i]) == true){
					tabDoublon[j] = potCommun.indexOf(tabChar[i]);
					
				}
				
					System.out.println("doublon : "+tabDoublon[]);
				
				if(tabChar[i] == potCommun.get(j)){
					index = potCommun.indexOf(tabChar[i]);
					tabIndex[i] = index;
					System.out.println("first index "+index);
					
					j--;
					break;
				}else if(j == potCommun.size()-1){
					
					return false;
				}
				
			}
			
		}
		
		System.out.println("index"+index);
		sortTabIndex(tabIndex);
		
		
		
		for(int a = 0; a < tabIndex.length; a++ ){
			if(findDoublon(tabIndex) == true){
				System.out.println("mot pas valide");
			}else{
				System.out.println("else"+tabIndex[a]);
				potCommun.remove(tabIndex[a]);
			}
		}
		/*for(int a = 0; a < tabIndex.length; a++ ){
			int var = tabIndex[a];
			for(int indice = 0; indice < tabIndex.length; indice++){
				if( index == var){
					System.out.println("mot pas valide");
				}else {
					potCommun.remove(tabIndex[a]);
				}
			}
			
				//letter = tabChar[a];
				//System.out.println("letter"+letter);
			
			
			//}
		
		return true;
	}
	*/
	
}
