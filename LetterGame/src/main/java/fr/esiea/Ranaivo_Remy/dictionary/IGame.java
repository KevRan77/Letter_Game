package fr.esiea.Ranaivo_Remy.dictionary;


public interface IGame{
	
	public void getChoiceNbPlayer();
	public int getInt();
	public String getString();
	public void setNbPlayer();
	public void initTabPlayer();
	public void setNameEnter();
	public void firstDraw(Player[] tabPlayer, Alphabet[] alphabet,Alphabet[] alphabet2 );
	public void printMutualBag();
	public void startGame(Alphabet[] alphabet, Alphabet[] alphabet2);
	public Player whoStart();
	public void sortArray();
	public void mutualBag(char letter);
	
}
