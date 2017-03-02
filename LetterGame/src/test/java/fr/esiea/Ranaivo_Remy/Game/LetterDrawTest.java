package fr.esiea.Ranaivo_Remy.Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fr.esiea.Ranaivo_Remy.Game.Components.Alphabet;
import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Core.LetterDraw;

public class LetterDrawTest {
	
	LetterDraw letterDraw = new LetterDraw();
	Alphabet[] alphabet = Alphabet.values();
	MutualBag mutualBag1 = new MutualBag();
	MutualBag mutualBag2 = new MutualBag();
	MutualBag mutualBag3 = new MutualBag();
	Player[] tabPlayer = new Player[2];
	Player target1 = new Player();
	Player target2 = new Player();
	
	@Before
	public final void beforeTestOneDraw(){
		mutualBag1.getMutualBag().remove(null);
		letterDraw.oneDraw(target1, mutualBag1);
	}
	
	@Test
	public final void testOneDraw() {
		assertNotNull("MutualBag n'est plus vide car une lettre a été piochée", mutualBag1.getMutualBag());
	}
	
	@Before
	public void beforeTestPlayerStarterDraw(){
		mutualBag2.getMutualBag().clear();
		letterDraw.playerStarterDraw(target2, mutualBag2);
	}
	@Test
	public void testPlayerStarterDraw(){
		assertNotNull("MutualBag n'est plus vide car 2 lettres ont été piochées", mutualBag2.getMutualBag());
	}
	
	@Before
	public void beforeTestFirstDraw(){
		mutualBag3.getMutualBag().clear();
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		
		letterDraw.firstDraw(tabPlayer, alphabet,mutualBag3);
	}
	@Test
	public void testFirstDraw(){
		assertNotNull("MutualBag n'est plus vide car 2 lettres ont été piochées", mutualBag3.getMutualBag());
	}

}