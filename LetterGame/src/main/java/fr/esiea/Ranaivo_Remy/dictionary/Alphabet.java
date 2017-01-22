package fr.esiea.Ranaivo_Remy.dictionary;

import java.util.Random;

/*public enum Alphabet {
	char Alphabet;
	 	
	
		public Alphabet(){
			Random r = new Random();
			this.Alphabet = (char)(r.nextInt(26) + 'a');
		}
		
		public char getAlphabet(){
			return this.Alphabet;
		}
		
}*/

public enum Alphabet
{
    A(120,1,'A'), B(20,2,'B'), C(15,3,'C'), D(16,4,'D'), E(150,5,'E'); /*F(20,6,'F'), G(23,7,'G'), H(18,8,'H'), I(122,9,'I'),
    J(17,10,'J'), K(14,11,'K'), L(20,12,'L'), M(30,13,'M'), N(18,14,'N'), O(95,15,'O'), P(25,16,'P'), Q(10,17,'Q'), R(25,18,'R'),
    S(60,19,'S'), T(55,20,'T'), U(103,21,'U'), V(20,22,'V'), W(2,23,'W'), X(3,24,'X'), Y(4,25,'Y'), Z(3,26,'Z');*/
    
    private final int occ;
    private final int numLetter;
    private final char letter;
    
    private Alphabet(int occ, int numLetter, char letter)
    {
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
    
    private static char[] tab = null;
    
    private static void fillTab()
    {
        int n = 0;
        
        for (Alphabet v : Alphabet.values())
            n += v.occ;
        
        tab = new char[n];
        
        int i = 0;
        for (Alphabet v : Alphabet.values())
            for (int j = 0; j < v.occ; i++ , j++ )
                tab[i] = v.toString().charAt(0);
    }
    
    public double getFrequency()
    {
        if (tab == null)
            fillTab();
        
        return ((double) occ) / tab.length;
    }
    
    private static Random rand = new Random();
    
    public static char random()
    {
        if (tab == null)
            fillTab();
        
        return tab[rand.nextInt(tab.length)];
    }
}


