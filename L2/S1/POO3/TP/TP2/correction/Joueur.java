import java.util.Scanner;
import java.util.LinkedList;

public class Joueur{
    private String nom;
    private Scanner scan;

    public Joueur(){
	this.nom="Anonyme";
	this.scan=new Scanner(System.in);
    }

    public void setNom(String s){
	this.nom = s;
    }

    public String getNom(){
	return this.nom;
    }

    public void finir(){
	scan.close();
    }
    public String demanderNom(){
	System.out.println("Quel est votre nom ?");
	return scan.nextLine();
    }

    /* La méthode ci-dessus vérifie si le String en entrée n'est consitué que de char qui sont des chiffres.*/
     private boolean isNombre(String s){
	if(s.isEmpty())
	    return false;
	else {
	    for(int i=0;i<s.length();i++){
		if(!Character.isDigit(s.charAt(i)))
		    return false;
	    }
	    return true;
	}
    }

    /* La méthode ci-dessous vérifie si le String en entrée est constitué d'un seul char et si ce char est une lettre.*/
    private boolean isLettre(String s){
	if(s.length()!=1)
	    return false;
	else
	    return Character.isLetter(s.charAt(0));
    }

    /*
       Une action est un String de la forme "x y z"
       où x="r" ou "d" (révéler ou poser/enlever drapeau), et y et z sont les coordonnées d'une case sur le plateau.
       La méthode ci-dessous vérifie si le String en entrée correspond bien à une action.
    */
    private boolean isAction(String s){
	Scanner sc = new Scanner(s);
	LinkedList<String> l = new LinkedList<String>();
	while(sc.hasNext()){
	    l.add(sc.next());
	}
	sc.close();
	return l.size()==3&&this.isLettre(l.get(0))&&(l.get(0).charAt(0)=='d'||l.get(0).charAt(0)=='r')&&this.isLettre(l.get(1))&&this.isNombre(l.get(2));
    }


    public boolean demanderJouer(){
	System.out.println("Voulez-vous jouer (oui/non) ?");
	String s = scan.nextLine().toUpperCase();
	while(!(s.equals("OUI")||s.equals("NON"))){
		System.out.println("Réponse invalide. Essayez de nouveau !");
		s=scan.nextLine().toUpperCase();
	    }
	    return s.equals("OUI");
    }

    public int[] demanderDimensions(){
	int[] dim =new int[2];
	String s;

	System.out.println("Quelle hauteur de grille ?");
	s=scan.nextLine();
	while(!this.isNombre(s)){
	    System.out.println("Réponse invalide. Essayez de nouveau.");
	    s=scan.nextLine();
	}
	dim[0] = Integer.parseInt(s);

	System.out.println("Quelle largeur de grille ?");
	s=scan.nextLine();
	while(!this.isNombre(s)){
	    System.out.println("Réponse invalide. Essayez de nouveau.");
	    s=scan.nextLine();
	}
	dim[1] = Integer.parseInt(s);

	return dim;
    }

    public int demanderNbMines(){
	System.out.println("Combien de mines ?");
	String s = scan.nextLine();
	while(!this.isNombre(s)){
	    System.out.println("Réponse invalide. Essayez de nouveau. ");
	    s=scan.nextLine();
	}
	return Integer.parseInt(s);
    }

    public int[] demanderAction(){

	int[] act = new int[3];
	System.out.println("Quelle action souhaitez-vous faire? (drapeau d, reveler r); r b 5 révèle la case B 5.");

	String rep = scan.nextLine();
	while(!this.isAction(rep)){
	    System.out.println("Réponse invalide. Essayez de nouveau.");
	    rep=scan.nextLine();
	}
	Scanner sc = new Scanner(rep);
	String act0 = sc.next();
    	    switch(act0){
	    case "d": act[0]=0;
		break;
	    case "r" : act[0]=1;
		break;
	    }
	    act[1]=(int) (sc.next().toUpperCase().charAt(0) -'A') +1;
	    act[2]=Integer.parseInt(sc.next());
	    sc.close();
	    return act;
    }

}
