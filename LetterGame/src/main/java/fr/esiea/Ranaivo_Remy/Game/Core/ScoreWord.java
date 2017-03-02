package fr.esiea.Ranaivo_Remy.Game.Core;

public class ScoreWord {
	String word;
	int idPlayer;
	
	//Constructeur
	public ScoreWord(){
		this.word = null;
		this.idPlayer = 0;
	}
	
	//Surcharge du constructeur
	public ScoreWord(String word, int idPlayer){
		this.word = word;
		this.idPlayer = idPlayer;
	}
	
	//Getter du mot
	public String getWord(){
		return this.word;
	}
	
	//Setter du mot
	public void setWord(String word){
		this.word = word;
	}
	
	//Getter de l'id du player
	public int getIdPlayer(){
		return this.idPlayer;
	}
	
	//Setter de l'id du player
	public void setIdPlayer(int idPlayer){
		this.idPlayer = idPlayer;
	}
}
