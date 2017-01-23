package fr.esiea.Ranaivo_Remy.dictionary;

public class Game extends Session {
	Session keyEnter = new Session();
	int a;
	String name;
	public Game(){
		
	}
	public int showNbPlayer(){
		do{
			keyEnter.getChoixNbPlayer();
			a = keyEnter.getInt();
		}while(a < 2);
		return a;
		}
	
	public String[] getNameEnter(){
		int i;
		int j;
		int c = showNbPlayer();
		String[] abc = new String[c];
		for(i = 1; i <= c;i++){
			System.out.println("Entrez le nom du Joueur "+i+" : ");
			abc[i-1] = keyEnter.getString();
		}
		return abc;
	}
	
	/*public void startGame(){
		char letterChosen;
		int j;
		int i;
		String []names = getNameEnter();
		for(i=0; i < a; i++){
			letterChosen = alphabet[i].random();
			for(j=0;j<25;j++){
				if(alphabet[j].getChar()==letterChosen){
					alphabet2[i] = alphabet[j];
				}
			}
			System.out.println("Lettre aléatoire du Player "+names[i]+" : "+ letterChosen);
			potCommun.add(letterChosen); 
			start[i] = alphabet2[i].getValue();
			playerName[i] = Player[i].getName(a[i]);
		}
	}*/

}
