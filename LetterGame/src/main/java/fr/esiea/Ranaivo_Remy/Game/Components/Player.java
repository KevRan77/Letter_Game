package fr.esiea.Ranaivo_Remy.Game.Components;

import java.util.ArrayList;

public class Player{
	 String name;
	int val;
	int score;
	Boolean play;
	public ArrayList<String> listWord = new ArrayList<String>();
	int IA;
	
	//Constructeur de Player
	public Player(){
		this.name = null;
		this.val = 0;
		this.score = 0;
		this.play = false;
		this.listWord.add("null");
		this.IA = 0;
	}
	
	//Getter IA mode
	public int getIA(){
		return this.IA;
	}
	
	//Setter IA mode
	public void setIA(int IA){
		this.IA = IA;
	}
	
	//Getter name du player
	public String getName(){
		return this.name;
	}
	
	//Setter name du player
	public void setName(String name){
		this.name = name;
	}
	
	//Getter listword du player
	public ArrayList<String> getListWord(){
		return this.listWord;
	}
	
	//Setter listword du player
	public void setListWord(ArrayList<String> listWord){
		this.listWord = listWord;
	}
	
	//Getter val
	public int getVal(){
		return this.val;
	}
	
	//Setter val
	public void setVal(int val){
		this.val = val; 
	}
	
	//Getter du score du player
	public int getScore(){
		return this.score;
	}
	
	//Setter du score du player
	public void setScore(int score){
		this.score = score;
	}

	//Getter play
	public Boolean getPlay(){
		return this.play;
	}
	
	//Setter play
	public void setPlay(Boolean play){
		this.play = play;
	}
	
	
}