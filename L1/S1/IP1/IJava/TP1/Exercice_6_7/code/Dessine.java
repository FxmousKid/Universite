/*
  Un programme simple pour dessiner
*/
public class Dessine{

    // Donnée de configuration du dessin
    public static Turtle turtle;
    static int picture_width  = 1024;
    static int picture_height = 1024;

    public static void main (String[] args) {
		// Configuration de la tortue
		turtle = new Turtle (picture_width,picture_height);
		turtle.setspeed (100);

		// Ici commence le code pour dessiner
		turtle.setheading (0);
		turtle.forward (100);
		
		turtle.setheading (90);
		turtle.forward (100);
		
		turtle.setheading (180);
		turtle.forward(100);
		
		turtle.setheading(270);
		turtle.forward(100);

		turtle.up() ;
		turtle.moveto(150, 150);
		turtle.down() ;
		
		turtle.forward(60);
		turtle.setheading(0);

		turtle.forward(60);
		turtle.setheading(90);
		
		turtle.forward(60);
		turtle.setheading(180);

		turtle.forward(60);
		turtle.setheading(270);
		// Ajoutez ci-dessous le code pour finir de dessiner le carré (question 3.)

		// Ajoutez ci-dessous les instructions de la question 4.

		//Code d'attente pour la fermeture de la fenetre : la fenetre se ferme en cliquant dessus
		turtle.exitonclick ();
    }

}
