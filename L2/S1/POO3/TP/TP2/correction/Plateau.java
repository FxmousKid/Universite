import java.util.Random;

public class Plateau{
    private int hauteur,largeur,nbMines,nbDrapeaux;

    private boolean[][] mines; //indique où sont les mines sur plateau.
    private int[][] etats; //chaque case du plateau a un état; 0:cachée sans drapeau, 1:cachée avec drapeau, 2:révélée.
    private int[][] adja; //Nombre de mines adjacentes à chaque case.

    public Plateau(int hauteur, int largeur, int nbMines){
	this.hauteur = hauteur;
	this.largeur = largeur;
	this.nbMines = nbMines;
	this.nbDrapeaux = 0;

	/*
	   Le vrai plateau se trouve entre 1..hauteur et 1..largeur.
	   On rajoute deux lignes et deux colonnes pour faciliter les calculs.
	*/
	this.mines = new boolean[hauteur+2][largeur+2];
	this.etats = new int[hauteur+2][largeur+2];
	this.adja = new int[hauteur+2][largeur+2];

	ajouteMinesAlea();
	calculeAdjacence();
    }

    private void ajouteMinesAlea(){
	Random r = new Random();
	int x,y;
	for(int i=0;i<this.nbMines;i++){
	    do{
	    x=r.nextInt(this.hauteur)+1;
	    y=r.nextInt(this.largeur)+1;
	}while(mines[x][y]==true);
	mines[x][y]=true;
	}
    }

    private void calculeAdjacence(){
	for(int i=1;i<=hauteur;i++){
	    for(int j=1;j<=largeur;j++){
		for (int k = -1; k <= 1; k++) {
		    for (int l = -1; l <= 1; l++) {
			adja[i][j] += (mines[i + k][j + l]) ? 1 : 0;
		    }
		}
		adja[i][j] -= (mines[i][j]) ? 1 : 0; // compté deux fois
	    }
	}
	/* Ci-dessous, on met les cases du bord de adja à -1 pour éviter les bugs lors du remplissage */
	for (int i=0; i<= hauteur+1; i++) {
	    adja[i][0] = -1;
	    adja[i][largeur+1]=-1;
	}

	for (int j=0; j<=largeur+1; j++){
	    adja[0][j] = -1;
	    adja[hauteur+1][j]=-1;
	}
    }

    public void revelerCase(int x,int y){
	etats[x][y]=2;
	if (adja[x][y] == 0) {
	    for (int k=-1; k<=1; k++) {
		for (int l=-1; l<=1; l++) {
		    if (etats[x+k][y+l]!=2)
			revelerCase(x+k,y+l);
		}
	    }
	}
    }

    public void drapeauCase(int x, int y){
	if(etats[x][y]==0){
	    etats[x][y]=1;
	    this.nbDrapeaux++;
	}
	else if(etats[x][y]==1){
	    etats[x][y]=0;
	    this.nbDrapeaux--;
	}
    }


    public void afficheHeader() {
	System.out.println("   ********************\n   * Mines / Drapeaux *\n   *  " + nbMines + "    /   " + nbDrapeaux + "      *\n   ********************");
	System.out.print("    ");
	for (int i = 1; i <= largeur; i++) {
	    System.out.print(" " + i + " ");
	}
	System.out.print("\n");
	System.out.println("    " + "-".repeat(largeur * 3)); // requires java 11
    }

    public void afficheTout() {
	afficheHeader();
	for (int i = 1; i <= hauteur; i++) {
	    char let = (char) (64 + i);
	    System.out.print(let + " | ");
	    for (int j = 1; j <= largeur; j++) {
		if (mines[i][j]) System.out.print(" * ");
		else System.out.print(" " + adja[i][j] + " ");
	    }
	    System.out.print("\n");
	}
	System.out.println();
    }

    public void afficheCourant() {
	afficheHeader();
	for (int i = 1; i <= hauteur; i++) {
	    char let = (char) (64 + i);
	    System.out.print(let + " | ");
	    for (int j = 1; j <= largeur; j++) {
		char c = '.';
		switch (etats[i][j]) {
		case 0:
		    c = '.';
		    break;
		case 2:
		    c = (char) (adja[i][j] + '0');
		    break;
		case 1:
		    c = '!';
		    break;
		}
		System.out.print(" ");
		System.out.print(c);
		System.out.print(" ");
	    }
	    System.out.print("\n");
	}
	System.out.println();
    }

    public boolean jeuGagne(){
	for (int i = 1; i <= hauteur; i++) {
	    for (int j = 1; j <= largeur; j++) {
		if ((etats[i][j]!=2) && (mines[i][j]==false) || this.jeuPerdu()){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean jeuPerdu(){
	for (int i=1; i<=hauteur; i++){
	    for(int j=1; j<=largeur; j++){
		if((etats[i][j]==2)&&(mines[i][j]==true))
		    return true;
	    }
	}
	return false;
    }
}
