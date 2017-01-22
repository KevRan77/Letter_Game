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
    A(120,1), B(20,2), C(15,3), D(16,4), E(150,5);/* F(20,6), G(23,7), H(18,8), I(122,9),
    J(17,10), K(14,11), L(20,12), M(30,13), N(18,14), O(95,15), P(25,16), Q(10,17), R(25,18),
    S(60,19), T(55,20), U(103,21), V(20,22), W(2,23), X(3,24), Y(4,25), Z(3,26);*/
    
    private final int occ;
    private final int numLetter;
    
    private Alphabet(int occ, int numLetter)
    {
        this.occ = occ;
        this.numLetter = numLetter;
    }
    
    public int getValue(){
    	return numLetter;
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


