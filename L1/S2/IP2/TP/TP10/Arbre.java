import java.util.LinkedList;


public class Arbre {
	private Noeud sommet;

	public Arbre(Noeud sommet) {
		this.sommet = sommet;
	}

	public Arbre() {
		this.sommet = null;
	}

	public void afficheInfixe() {
		System.out.print("Le parcour infixe est : ");	
		sommet.afficheInfix();
	}

	public void affichePrefixe() {
		System.out.print("Le parcour prefixe est : ");
		sommet.affichePrefixe();
	}

	public void afficheSuffix() {
		this.affichePrefixe();
		System.out.println();
		System.out.print("Le parcour infixe est : ");
		sommet.afficheSuffix();
	}

	public int nbDeNoeuds() {
		return (sommet.nbDeNoeuds());	
	}

	public int somme() {
		return (sommet.somme());
	}

	public int hauteur() {
		return (sommet.hauteur());
	}

	public boolean recherche(int e) {
		return (sommet.recherche(e));
	}

	public Arbre(Arbre a) {
		if (a == null)
			return ;

		sommet = a.sommet.copyTo();		
	}

	public void affichePencher() {
		if (this.sommet == null)
			return ;
		
		this.sommet.affiche(0);
	}

	public void parcourLargeur() {
	}
}
