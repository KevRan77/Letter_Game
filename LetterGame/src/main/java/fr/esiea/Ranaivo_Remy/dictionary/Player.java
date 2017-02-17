package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.ArrayList;

public class Player{
	String name;
	int val;
	int score;
	Boolean play;
	ArrayList<String> listWord = new ArrayList<String>();
	
	public Player(){
		this.name = null;
		this.val = 0;
		this.score = 0;
		this.play = false;
		this.listWord = null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public ArrayList<String> getListWord(){
		return this.listWord;
	}
	
	public void setListWord(ArrayList<String> listWord){
		this.listWord = listWord;
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

	public Boolean getPlay(){
		return this.play;
	}
	
	public void setPlay(Boolean play){
		this.play = play;
	}
	
	
}