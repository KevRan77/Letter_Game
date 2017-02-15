package fr.esiea.Ranaivo_Remy.dictionary;

public class Player{
	String name;
	int val;
	int score;
	
	public Player(){
		this.name = null;
		this.val = 0;
		this.score = 0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getVal(){
		return this.val;
	}
	
	public void setVal(int val){
		this.val = val; 
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}

	
	
}
