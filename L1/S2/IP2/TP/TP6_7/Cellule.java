public class Cellule {  

    private Cellule precedente; 
    private Cellule suivante;
    private boolean noire;
    private boolean prochainEtat;

    public Cellule getPrecedente() {
        // renvoie la Cellule precedente
        return this.precedente;
    }

    public void setPrecedente(Cellule cel) {
        // Set the previous cell
        this.precedente = cel;
    }

    public Cellule getSuivante() {
        // renvoie la Cellule suivate
        return this.suivante;
    }   

    public void setSuivante(Cellule cel) {
        // Set the next Cell
        this.suivante = cel;
    }

    public boolean getNoire() {
        // Renvoie la valeur noire de cette cellule
        return this.noire;
    }

    public void setNoire(boolean n) {
        // Changes the value of noire
        this.noire = n;
    }

    public boolean getProchaineEtat() {
        // Returns the value of prochaine etat
        return (this.prochainEtat);
    }

    public void setProchaineEtat(boolean n) {
        // Sets the value of this.prochaineEtat
        this.prochainEtat = n;
    }

    public Cellule(boolean n) {
        this.noire = n;
        this.precedente = null;
        this.suivante = null;
    }    

    public void afficher() {
        // Affiche la valeur de la cellule
        System.out.print(this.noire ? "#" : "-");
    }
}
