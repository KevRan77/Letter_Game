package fr.esiea.Ranaivo_Remy.Game;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import fr.esiea.Ranaivo_Remy.Game.Components.MutualBag;
import fr.esiea.Ranaivo_Remy.Game.Components.Player;
import fr.esiea.Ranaivo_Remy.Game.Components.Words;
import fr.esiea.Ranaivo_Remy.Game.Core.LetterDraw;

public class WordsTest {

	Words words = new Words();
	Player target = new Player();
	Player test = new Player();
	Player[] tabPlayer = new Player[2];
	MutualBag mutualBag = new MutualBag();
	LetterDraw letterdraw = new LetterDraw();
	ArrayList<Character> list = new ArrayList<Character>();
	File currentDirFile = new File("src/main/resources/dico.txt");
	String helper = currentDirFile.getAbsolutePath();
	String line = "mous";
	String iaList = "MOUS";
	int val = 0;
	int i = 0;
	
	
	@Test
	//teste si la fonction ignore bien les accents
	public final void testRemoveAccent() {
		assertEquals("reve",words.removeAccent("rêve"));
	}

	
	@Before
	public final void beforeTest(){
		ArrayList<String> listWord = new ArrayList<String>(1);
		listWord.add("mot");
		target.setListWord(listWord);
		test.listWord.remove(0);
	}
	
	@Test
	//teste si la fonction a bien identifie le mot "mot" comme etant le mot vole.
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
	//teste si la chaine de caractere ecrite au clavier a bien ete designe comme celui a qui on volait un mot.
	public final void testWhoIsStolen() {
		assertEquals(target.getName(),words.whoIsStolen(tabPlayer, "Target").getName());
		
	}
	
	@Before
	public final void beforeTestStatPlayer(){
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		tabPlayer[0].setScore(0);
		tabPlayer[1].setScore(0);
		
		list.add('M');
		list.add('O');
		list.add('U');
		list.add('S');
		mutualBag.setMutualBag(list);
	}
	
	@Test
	public final void testStatPlayer(){
		words.statPlayer(0, tabPlayer, "de");
		//teste si le score du joueur a bien augmente d'un point
		assertEquals(1,tabPlayer[0].getScore());
		//teste si le mot "de" s'est bien ajoute dans la liste des mots du joueur l'ayant entre.
		assertEquals("de",tabPlayer[0].getListWord().get(1));
	}
	
	@Before
	public final void beforeTestSucceedTheft(){
		tabPlayer[0] = new Player();
		tabPlayer[1] = new Player();
		tabPlayer[0].setScore(0);
		tabPlayer[1].setScore(0);
		test.setScore(0);
		target.setScore(1);
	}
	
	@Test
	public final void testSucceedTheft(){
		String newWord = "mousse";
		words.succeedTheft(mutualBag, list, target, test, newWord, 0);
		//teste si le le joueur a qui on vole un mot a bien perdu un point
		assertEquals(0,target.getScore());
		//teste si le joueur qui vole un mot a bien recupere un point
		assertEquals(1,test.getScore());
		//teste si le joueur qui a vole le mot a bien recuperer ce mot dans sa liste
		assertEquals(newWord,test.listWord.get(0));
		//teste si le pot commun est vide (cad que les lettres ont bien ete retirees du pot commun)
		assertTrue("teste si le pot commun est vide",mutualBag.getMutualBag().isEmpty());
		
	}
	
	@Before
	public final void beforeTestSearchInDicoBasic(){
		tabPlayer[0] = new Player();
		tabPlayer[0].setVal(0);
	}
	
	@Test
	//teste si l'on rentre dans la condition qui verifie la correlation entre le dico, le mot entre et le pot commun
	public final void testSearchInDicoBasic(){
    	try {
			Scanner file = new Scanner(new File(helper));
			words.searchInDicoBasic(file, line, mutualBag, i, tabPlayer, val, letterdraw);
			assertEquals(1,tabPlayer[i].getVal());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public final void beforeTestSearchInDicoIA(){
		tabPlayer[0].setVal(0);
	}
	
	@Test
	//teste si l'on rentre dans la condition qui verifie la correlation entre le dico et le pot commun
	public final void testSearchInDicoIA(){
		try {
			Scanner file = new Scanner(new File(helper));
			words.searchInDicoIA(iaList, file, mutualBag, i, tabPlayer,letterdraw);
			assertEquals(1,tabPlayer[i].getVal());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}