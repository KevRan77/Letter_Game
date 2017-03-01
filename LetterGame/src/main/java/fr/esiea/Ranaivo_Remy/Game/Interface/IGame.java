package fr.esiea.Ranaivo_Remy.Game.Interface;

import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;


public interface IGame{
	
	public String getString();
	public int setNbPlayer();
	public void initTabPlayer(int gameMode);
	public void setNameEnter();
	public void startGame(Alphabet[] alphabet);
	public Player whoStart(Player[] tabPlayer);
	public Player[] sortArray(Player[] tabPlayer);
	
}