package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Random;

public class Alphabet {
	char letter;
	//int[] voy = new int[6];
	
		public Alphabet(){
			Random r = new Random();
			this.letter = (char)(r.nextInt(26) + 'a');
			/*int i;
			switch(this.letter){
			case 'a' : voy[0]++;
			break;
			case 'e' : voy[1]++;
			break;
			case 'i' : voy[2]++;
			break;
			case 'o' : voy[3]++;
			break;
			case 'u' : voy[4]++;
			break;
			case 'y' : voy[5]++;
			break;
			default : break;
			}*/
		}
		
		public char getLetter(){
			return this.letter;
		}
		
}


