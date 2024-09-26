public class Jeu{
    private Joueur player;
    private Plateau board;

    public Jeu(Joueur player, Plateau board){
	this.player=player;
	this.board=board;
    }

    public void jouer(){
	boolean playing = true;
	while(playing){
	    board.afficheCourant();
	    int[] action=player.demanderAction();
	    switch(action[0]){
	    case 0:board.drapeauCase(action[1],action[2]);
		break;
	    case 1:board.revelerCase(action[1],action[2]);
		break;
	    }
	    if(board.jeuGagne()){
		board.afficheTout();
		System.out.println("\n Vous avez gagné ! \n");
		playing=false;
	    }
	    if(board.jeuPerdu()){
		board.afficheTout();
		System.out.println("\n Vous avez perdu ! \n");
		playing=false;
	    }
	}
    }
}
