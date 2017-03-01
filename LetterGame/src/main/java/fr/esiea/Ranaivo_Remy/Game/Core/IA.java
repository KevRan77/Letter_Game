package fr.esiea.Ranaivo_Remy.Game.Core;

import java.util.ArrayList;

<<<<<<< HEAD
public class IA{
	
	ArrayList<Character> iaBag = new ArrayList<Character>();
	int iaMode;
	
	public IA(){
		this.iaBag = null;
		this.iaMode = 0;
		//Alphabet[] alphabet = Alphabet.values();
		//startGameIA(alphabet);
	}
	
=======
import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;

public class IA{
	
	ArrayList<Character> iaBag = new ArrayList<Character>();
	int iaMode;
	public IA(){
		this.iaBag = null;
		this.iaMode = 0;
		//Alphabet[] alphabet = Alphabet.values();

		//startGameIA(alphabet);
	}
>>>>>>> refs/remotes/origin/master
	public ArrayList<Character> getIaBag(){
		return this.iaBag;
	}
	
	public void setIaBag(ArrayList<Character> iaBag){
		this.iaBag = iaBag;
	}
	
	public int getIaMode(){
		return this.iaMode;
	}
	public void setIaMode(int iaMode){
		this.iaMode = iaMode;
	}
}
