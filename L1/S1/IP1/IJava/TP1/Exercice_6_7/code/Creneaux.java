/*
  Un programme simple pour dessiner des creneaux
*/
public class Creneaux{

    // Donnée de configuration du dessin
    public static Turtle turtle;
    static int picture_width  = 1024;
    static int picture_height = 1024;

    public static void main (String[] args) {
	// Configuration de la tortue
	turtle = new Turtle (picture_width,picture_height);
	turtle.setspeed (100);

	// Ici commence le code pour dessiner
	turtle.up();
	turtle.moveto(-400,0);
	turtle.down();

	for(int i=0;i<4;i=i+1){
		int largeur = 40 - 10 * i ;

	    turtle.setheading (0);
	    turtle.forward (largeur);
	    turtle.setheading (90);
	    turtle.forward (largeur);
	    turtle.setheading (0);
	    turtle.forward (largeur);
	    turtle.setheading (-90);
	    turtle.forward (largeur);
	}

	//Code d'attente pour la fermeture de la fenetre
	turtle.exitonclick ();
    }

}

// 1. on modifie la ligne 21, le "i<x" ave x le nombre de creneaux que l'on veut dessiner
// 2. afin de rendre les creneaux plus hauts, on modifie la ligne 25 et la ligne 29 en leur
// mettant la meme distance, en la mettant aussi grande que l'on veut. pour les faires 
// moins larges, il faut simplement reduire la ligne 23 et la ligne 27 en terme de distance
