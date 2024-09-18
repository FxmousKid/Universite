public class Main {

	public static void main(String[] args) {
		Noeud a = new Noeud(6 , null , new Noeud (8));
		Noeud b = new Noeud(9 , new Noeud (2) , a );
		Noeud c = new Noeud(5 , b , null );
		Noeud d = new Noeud(1 , new Noeud (4) , null );
		Noeud e = new Noeud(7 , new Noeud (0) , d );
		Noeud f = new Noeud(3 , c , e );
		Arbre g = new Arbre( f );
		g.afficheSuffix();
		System.out.println("\n");
		g.nbDeNoeuds();
		System.out.println("Le nombre de noeuds de cette arbre vaut " + g.nbDeNoeuds());
		System.out.println("La somme des etiquettes de cette arbre vaut " + g.somme());
		System.out.println("La hauteur de cette arbre est " + g.hauteur());
		System.out.println("7 est une etiquette de l'arbre " + g.recherche(7));

		System.out.println("\n\nNous allons maintenant faire une copy de g dans abr\n");
		Arbre abr = new Arbre(g);

		abr.afficheSuffix();
		System.out.println("\n");
		abr.nbDeNoeuds();
		System.out.println("Le nombre de noeuds de cette la copy vaut " + abr.nbDeNoeuds());
		System.out.println("La somme des etiquettes de la copy vaut " + abr.somme());
		System.out.println("La hauteur de la copy est " + abr.hauteur());
		System.out.println("7 est une etiquette de la copy " + abr.recherche(7));

	}
}
