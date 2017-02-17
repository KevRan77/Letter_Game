package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Random;

public enum Alphabet{
	
    a(120,1,'a'), b(20,2,'b'), c(15,3,'c'), d(16,4,'d'), e(150,5,'e'), f(20,6,'f'), g(23,7,'g'), h(18,8,'h'), i(122,9,'i'),
    j(17,10,'j'), k(14,11,'k'), l(20,12,'l'),m(30,13,'m'), n(18,14,'n'), o(95,15,'o'), p(25,16,'p'), q(10,17,'q'), r(25,18,'r'),
    s(60,19,'s'), t(55,20,'t'), u(103,21,'u'), v(20,22,'v'), w(2,23,'w'), x(3,24,'x'), y(4,25,'y'), z(3,26,'z');
    
    // *****  Variables  ***** \\ 
    private final int occ;
    private int numLetter;
    private char letter;
    
    private static char[] tab = null;
    private static Random rand = new Random();	
    
    // ***** Méthodes ***** \\
    private Alphabet(int occ, int numLetter, char letter){
        this.occ = occ;
        this.numLetter = numLetter;
        this.letter = letter;
    }
    
    public int getValue(){
    	return numLetter;
    }
    
    public char getChar(){
    	return letter;
    }
    
    public void setChar(char letter){
    	this.letter = letter;
    }
    public void setValue(int numLetter){
    	this.numLetter = numLetter;
    }
    
    private static void fillTab(){
        int n = 0;
        
        for (Alphabet v : Alphabet.values())
            n += v.occ;
        
        tab = new char[n];
        
        int i = 0;
        for (Alphabet v : Alphabet.values())
            for (int j = 0; j < v.occ; i++ , j++ )
                tab[i] = v.toString().charAt(0);
    }
    
    public double getFrequency(){
        if (tab == null)
            fillTab();
        
        return ((double) occ) / tab.length;
    }
    

    
    public static char random(){
        if (tab == null)
            fillTab();
        
        return tab[rand.nextInt(tab.length)];
    }
}

