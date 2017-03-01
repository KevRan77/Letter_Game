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
	
	@Test
	public final void testMutualBagAddLetter() {
		char letter = 'a';
		
		mutualBag.mutualBagAddLetter(letter);
		assertEquals(mutualBagTest.getMutualBag(),mutualBag.getMutualBag());
		//System.out.println(mutualBagTest.getMutualBag());
		//System.out.println(mutualBag.getMutualBag());
	}
	
	@Test
	public final void testVerifLetterMutualBag() {
		String word = "a";
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');
		mutualBagTest.setMutualBag(list);
		assertTrue("Should return true if letter in the mutualBag",mutualBagTest.verifLetterMutualBag(word, list));
	}


}
