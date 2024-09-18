import java.lang.Math;

public class Noeud {

	private int etiquette;
	private Noeud gauche;
	private Noeud droit;

	public Noeud(int etiquette, Noeud g, Noeud d) {
		this.etiquette = etiquette;
		this.gauche = g;
		this.droit = d;
	}


	public Noeud getGauche() {
		return (this.gauche);
	}

	public int getEtiquette() {
		return (this.etiquette);
	}

	public Noeud getDroit() {
		return (this.droit);
	}

	public Noeud(int etiquette) {
		this(etiquette, null, null);
	}

	public void afficheInfix() {
		if (this.gauche != null) 
			this.gauche.afficheInfix();
		System.out.print(etiquette + " ");
		if (this.droit != null)
			this.droit.afficheInfix();
	}

	public void affichePrefixe() {
		System.out.print(etiquette + " ");
		if (this.gauche != null) 
			this.gauche.affichePrefixe();
		if (this.droit != null)
			this.droit.affichePrefixe();
	}

	public void afficheSuffix() {
		if (this.gauche != null) 
			this.gauche.afficheSuffix();
		if (this.droit != null)
			this.droit.afficheSuffix();
		System.out.print(etiquette + " ");
	}

	public int nbDeNoeuds() {
		if (gauche == null && droit == null)
			return (1);

		if (gauche == null)
			return (1 + droit.nbDeNoeuds());
		
		if (droit == null)
			return (1 + gauche.nbDeNoeuds());

		return (1 + gauche.nbDeNoeuds() + droit.nbDeNoeuds());
	}

	public int somme() {
		if (gauche == null && droit == null)
			return (etiquette);

		if (gauche == null)
			return (etiquette + droit.somme());
		
		if (droit == null)
			return (etiquette + gauche.somme());

		return (etiquette + gauche.somme() + droit.somme());
	}

	public int hauteur() {
		if (gauche == null && droit == null)
			return (0);

		if (gauche == null)
			return (1 + droit.hauteur());
		
		if (droit == null)
			return (1 + gauche.hauteur());

		return (1 + Math.max(droit.hauteur(), gauche.hauteur()));
	}

	public boolean recherche(int e) {
		if (etiquette == e)
			return (true);

		if (droit == null && gauche == null)
			return (false);

		if (droit == null)
			return (false || gauche.recherche(e));
		
		if (gauche == null)
			return (false || droit.recherche(e));

		return (false || droit.recherche(e) || gauche.recherche(e));
	}

	public Noeud copyTo() {
		Noeud newNode = new Noeud(etiquette);

		if (gauche != null) {
			newNode.gauche = gauche.copyTo(); 
		}

		if (droit != null) {
			newNode.droit = droit.copyTo();
		}

		return newNode;
	}
}
