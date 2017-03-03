package fr.esiea.Ranaivo_Remy.Game;

import org.junit.Test;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Core.Game;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

 
public class GameTest {
	
	Game test = new Game(1);
	
	//Test qui verifie que le bon joueur commence
	@Test
	public final void testWhoStart() {
		Player[] tabPlayer = new Player[2];
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		
		tabPlayer[0].setVal(20);
		tabPlayer[1].setVal(10);
		
		tabPlayer[0].setName("joueur1");
		tabPlayer[1].setName("joueur2");
		
		assertSame("Le joueur2 commence", tabPlayer[1],test.whoStart(tabPlayer));	 

	
	}
	
	//Test qui verifie que le tableau est bien trie
	@Test
	public final void testSortArray() {
		Player[] tabPlayer = new Player[2];
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		boolean flag = false;
		
		tabPlayer[0].setVal(20);
		tabPlayer[1].setVal(10);
				test.sortArray(tabPlayer);

		if(tabPlayer[0].getVal() < tabPlayer[1].getVal()){
			flag = true;
		}
		
		assertTrue("Tableau trie", flag);
	}
	
	//Test qui verifie qu'on entre bien dans le mode ia
	@Test
	public final void setNbPlayer(){
		InputStream stdin = System.in;
		try{
		System.setIn(new ByteArrayInputStream("2".getBytes()));
		Game test = new Game(1);
		int mode = test.setNbPlayer();
		assertEquals(2,mode);
		}finally{
		System.setIn(stdin);
		}
	}
	
	

}
