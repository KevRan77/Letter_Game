package fr.esiea.Ranaivo_Remy.dictionary;



public interface IGame{
	
	public String getString();
	public void setNbPlayer();
	public void initTabPlayer();
	public void setNameEnter();
	//public void firstDraw(Player[] tabPlayer, Alphabet[] alphabet,Alphabet[] alphabet2 );
	//public void printMutualBag();
	public void startGame(Alphabet[] alphabet, Alphabet[] alphabet2);
	public Player whoStart(Player[] tabPlayer);
	public Player[] sortArray(Player[] tabPlayer);
	//public void mutualBag(char letter);
	//public Boolean verifLetterMutualBag(String word, ArrayList<Character> potCommun);
	
}