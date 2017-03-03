package fr.esiea.Ranaivo_Remy.Game;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;

public class MutualBagTest {
	
	MutualBag mutualBag = new MutualBag();
	MutualBag mutualBagTest = new MutualBag();

	@Before
	public void initialize(){
		ArrayList<Character> list = new ArrayList<Character>();
		list.add(null);
		list.add('a');
		list.set(0, null);
		list.set(1, 'a');
		mutualBagTest.setMutualBag(list);
	}
	
	//Test qui verifie que la methode ajoute bien une lettre dans le mutualbag
	@Test
	public final void testMutualBagAddLetter() {
		char letter = 'a';
		
		mutualBag.mutualBagAddLetter(letter);
		assertEquals(mutualBagTest.getMutualBag(),mutualBag.getMutualBag());
	}
	
	//Test qui vérifie si la lettre est dans le mutualbag
	@Test
	public final void testVerifLetterMutualBag() {
		String word = "a";
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		mutualBagTest.setMutualBag(list);
		assertTrue("Retourne true s'il y a la lettre dans le mutualBag",mutualBagTest.verifLetterMutualBag(word, list));
	}


}
