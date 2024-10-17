public abstract class Personnage implements Cloneable {
    private String nom;
    private int pdv;
    private Action primaire;
    private Action secondaire;
    private EtatPersonnage etat = new EtatNormal();
    
    public Personnage(String nom, Action primaire, Action secondaire) {
	this.pdv = pdvInitiaux();
	this.nom = nom;
	this.primaire = primaire;
	this.secondaire = secondaire;
    }
    
    public abstract int pdvInitiaux();
	
    public void setEtat(EtatPersonnage etat) {
	this.etat = etat;
    }
	
    private void action(Personnage personnage, Action action) {
	personnage.pdv += etat.alteration(action.alterationCible());
	pdv += etat.alteration(action.alterationSource());
    }
	
    public void actionPrimaire(Personnage personnage) {
	action(personnage, primaire);
    }
    
    public void actionSecondaire(Personnage personnage) {
	action(personnage, secondaire);
    }
	
    public Personnage clone() throws CloneNotSupportedException {
	Personnage cloned = (Personnage) super.clone();
	cloned.primaire = primaire.clone();
	cloned.secondaire = secondaire.clone();
	cloned.etat = etat.clone();
	return cloned;
    }
	
    public boolean equals(Object o) {
	if (o.getClass() != this.getClass())	
	    return false;
	Personnage p = (Personnage) o;
	return nom.equals(p.nom) &&
	    pdv == p.pdv &&
	    etat == p.etat &&
	    primaire.equals(p.primaire) &&	
	    secondaire.equals(p.secondaire);
    }
	
    // accesseurs, uniquement pour les tests.
    public String getNom() {
	return nom;
    }
    public EtatPersonnage getEtat() {
	return etat;
    }	
    public Action getPrimaire() {
	return primaire;
    }
    public Action getSecondaire() {
	return primaire;
    }	
}

