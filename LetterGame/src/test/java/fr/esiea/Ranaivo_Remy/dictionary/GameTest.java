package fr.esiea.Ranaivo_Remy.dictionary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	@Test
	public final void testGame() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testGetChoiceNbPlayer() {	
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetNbPlayer() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInitTabPlayer() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetNameEnter() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFirstDraw() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testPrintMutualBag() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testStartGame() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWhoStart() {
		Game test = new Game();
		Player[] tabPlayer = new Player[2];
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		
		tabPlayer[0].val = 20;
		tabPlayer[1].val = 10;
		
		tabPlayer[0].name = "joueur1";
		tabPlayer[1].name = "joueur2";
		
		assertSame("Le joueur2 commence", tabPlayer[1],test.whoStart(tabPlayer));	 
		
		
	}

	@Test
	public final void testSortArray() {
		Game test = new Game();
		Player[] tabPlayer = new Player[2];
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		
		tabPlayer[0].setVal(20);
		tabPlayer[1].setVal(10);
				test.sortArray(tabPlayer);
				
		boolean flag = false;
		
		if(tabPlayer[0].val < tabPlayer[1].val){
			flag = true;
		}
		
		assertTrue("Test réussi", flag);
	}

	@Test
	public final void testMutualBag() {
		fail("Not yet implemented"); // TODO
	}

}
