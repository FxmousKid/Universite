/*
  Un programme simple pour dessiner des creneaux
*/
public class spirale_carre {

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
	
	for (int i=0; i<=27; i++ ) {
		turtle.setheading(90*(i % 4));
		turtle.forward(200 - 4 * i);
		
	};
	turtle.exitonclick ();
};

};

