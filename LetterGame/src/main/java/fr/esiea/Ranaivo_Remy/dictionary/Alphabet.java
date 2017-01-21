package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Random;

public class Alphabet {
	char letter;
	
		public Alphabet(){
			Random r = new Random();
			this.letter = (char)(r.nextInt(26) + 'a');
		}
		
		public char getLetter(){
			return this.letter;
		}
		
}


