package fr.esiea.Ranaivo_Remy.Game.Core;

import java.util.ArrayList;

import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;

public class IA{
	
	ArrayList<Character> iaBag = new ArrayList<Character>();
	public IA(){
		this.iaBag = null;
		//Alphabet[] alphabet = Alphabet.values();

		//startGameIA(alphabet);
	}
	public ArrayList<Character> getIaBag(){
		return this.iaBag;
	}
	
	public void setIaBag(ArrayList<Character> iaBag){
		this.iaBag = iaBag;
	}
}
