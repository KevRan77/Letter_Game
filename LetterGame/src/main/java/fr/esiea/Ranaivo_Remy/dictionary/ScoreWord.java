package fr.esiea.Ranaivo_Remy.dictionary;

public class ScoreWord {
	String word;
	int idPlayer;
	
	public ScoreWord(){
		this.word = null;
		this.idPlayer = 0;
	}
	
	public ScoreWord(String word, int idPlayer){
		this.word = word;
		this.idPlayer = idPlayer;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public int getIdPlayer(){
		return this.idPlayer;
	}
	
	public void setIdPlayer(int idPlayer){
		this.idPlayer = idPlayer;
	}
}
