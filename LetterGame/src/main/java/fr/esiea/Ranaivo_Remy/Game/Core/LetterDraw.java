package fr.esiea.Ranaivo_Remy.Game.Core;

import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;

public class LetterDraw {

	public LetterDraw(){}
	
	//Tire une lettre aleatoire, la met dans le pot commun et l'affiche avec son joueur associe
	public void oneDraw(Player player, MutualBag mutualBag ){
		char letterChosen;
	
		letterChosen = Alphabet.random();
		mutualBag.mutualBagAddLetter(letterChosen);
		System.out.println(player.getName()+" pioche : "+letterChosen);
		mutualBag.printMutualBag();
	}
	
	//Piochement des deux lettres au debut du jeu
	public void playerStarterDraw(Player player, MutualBag mutualBag){
		char letterChosen;
		
		for(int i =0; i<2;i++){
			letterChosen = Alphabet.random();
			mutualBag.mutualBagAddLetter(letterChosen);
			System.out.println(player.getName()+" pioche : "+letterChosen);
		}
		mutualBag.printMutualBag();
	}
	
	//Attribut une lettre aleatoire aux joueurs et remplit ces lettres dans le pot commun
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
					tabPlayer[i].setVal(alphabet[j].getValue());
					System.out.println(tabPlayer[i].getName()+" pioche la lettre "+letterChosen);
					alphabet[j].setChar('0');
				}
			}
		}
	}
}
