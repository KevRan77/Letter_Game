package fr.esiea.Ranaivo_Remy.Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Components.Words;

public class WordsTest {

	Words words = new Words();
	Player target = new Player();
	Player[] tabPlayer = new Player[2];
	
	
	@Test
	public final void testRemoveAccent() {
		assertEquals("reve",words.removeAccent("rêve"));
	}

	
	@Test
	public final void testPlayerListScoreWord(){
		//Todo
	}
	
	@Before
	public final void beforeTestWhoIsStolen(){
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		tabPlayer[0].setName("Target");
		tabPlayer[1].setName("Test");
		target.setName("Target");
	}
	
	@Test
	public final void testWhoIsStolen() {		
		assertEquals(target.getName(),words.whoIsStolen(tabPlayer, "Target").getName());
		
	}

}
