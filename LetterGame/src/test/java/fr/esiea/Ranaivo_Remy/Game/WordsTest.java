package fr.esiea.Ranaivo_Remy.Game;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Components.Words;

public class WordsTest {

	Words words = new Words();
	Player target = new Player();
	Player[] tabPlayer = new Player[2];
	MutualBag mutualBag = new MutualBag();
	
	
	@Test
	public final void testRemoveAccent() {
		assertEquals("reve",words.removeAccent("rêve"));
	}

	
	@Before
	public final void beforeTest(){
		ArrayList<String> listWord = new ArrayList<String>(1);
		listWord.add("mot");
		target.setListWord(listWord);
	}
	
	@Test
	public final void testWhichWordStolen(){
		assertEquals(0,words.whichWordStolen(target, "mot"));
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
