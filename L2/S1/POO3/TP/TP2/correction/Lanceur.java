public class Lanceur{
    public static void main(String[] args){
    Joueur player = new Joueur();
    player.setNom(player.demanderNom());
    System.out.println("\n  Bonjour " + player.getNom() + " ! \n");
    boolean b = player.demanderJouer();
    while(b){
    int[] dim = player.demanderDimensions();
    int nbMines = player.demanderNbMines();
    Plateau board = new Plateau(dim[0],dim[1],nbMines);
    Jeu game = new Jeu(player,board);
    game.jouer();
    b=player.demanderJouer();
    }
    System.out.println("\n  À bientôt !");
    player.finir();
    }
}
