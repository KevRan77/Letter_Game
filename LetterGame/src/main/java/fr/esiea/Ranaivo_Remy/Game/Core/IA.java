package fr.esiea.Ranaivo_Remy.Game.Core;

import java.util.ArrayList;

public class IA{
	
	ArrayList<Character> iaBag = new ArrayList<Character>();
	int iaMode;
	
	//Constructeur
	public IA(){
		this.iaBag = null;
		this.iaMode = 0;
	}

	//Getter du pot de l'ia
	public ArrayList<Character> getIaBag(){
		return this.iaBag;
	}
	
	//Setter du pot de l'ia
	public void setIaBag(ArrayList<Character> iaBag){
		this.iaBag = iaBag;
	}
	
	//Getter du mode ia
	public int getIaMode(){
		return this.iaMode;
	}
	
	//Setter du mode ia
	public void setIaMode(int iaMode){
		this.iaMode = iaMode;
	}
}
