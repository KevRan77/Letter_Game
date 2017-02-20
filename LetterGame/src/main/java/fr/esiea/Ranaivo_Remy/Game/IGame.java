package fr.esiea.Ranaivo_Remy.Game;




public interface IGame{
	
	public String getString();
	public void setNbPlayer();
	public void initTabPlayer();
	public void setNameEnter();
	public void startGame(Alphabet[] alphabet);
	public Player whoStart(Player[] tabPlayer);
	public Player[] sortArray(Player[] tabPlayer);
	
}