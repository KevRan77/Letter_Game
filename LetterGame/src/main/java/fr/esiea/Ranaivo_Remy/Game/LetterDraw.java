package fr.esiea.Ranaivo_Remy.Game;

public class LetterDraw {
	
	public LetterDraw(){}
		
	public void oneDraw(Player player, MutualBag mutualBag ){
		char letterChosen;
	
		letterChosen = Alphabet.random();
		mutualBag.mutualBagAddLetter(letterChosen);
		System.out.println("Le joueur "+player.name+" a pioché : "+letterChosen);
		mutualBag.printMutualBag();
	}
	
	public void playerStarterDraw(Player player, MutualBag mutualBag){
		char letterChosen;
		
		for(int i =0; i<2;i++){
			letterChosen = Alphabet.random();
			mutualBag.mutualBagAddLetter(letterChosen);
			System.out.println("Le joueur "+player.name+" a pioché : "+letterChosen);
		}
		mutualBag.printMutualBag();
	}
	
	//Attribut une lettre alétoire aux joueurs et remplit ces lettres dans le pot commun
	public void firstDraw(Player[] tabPlayer, Alphabet[] alphabet, MutualBag mutualBag ){
		int i,j;
		char letterChosen;
		
		for(i=0; i<tabPlayer.length; i++){
			letterChosen = Alphabet.random();	
			alphabet[i].setChar(letterChosen);
			alphabet[i].setValue(letterChosen);
	
			for(j=0;j<25;j++){	
				if(alphabet[j].getChar()==letterChosen){
					mutualBag.mutualBagAddLetter(letterChosen);
					tabPlayer[i].val = alphabet[j].getValue();
					System.out.println("Le joueur "+tabPlayer[i].name+" a pioché la lettre "+letterChosen);
					alphabet[j].setChar('0');
				}
			}
		}
	}
	
}
