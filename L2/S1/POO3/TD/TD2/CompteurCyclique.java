public class CompteurCyclique {
    private int valeur;
    private final int sup;

    public CompteurCyclique(int sup) {
        this(sup, 0);
    }

    public CompteurCyclique(int sup, int valeur) {
        this.sup = sup;
        setValeur(valeur);
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
	this.valeur = ((valeur % sup) + sup) % sup;
    }
    
    public void reinitialiser() {
        valeur = 0;
    }

    public boolean incrementer() {
	valeur = (valeur + 1) % sup;
        return valeur == 0;
    }

    private String toStringManuel() {
        int nbChiffres = Integer.toString(sup - 1).length();
        String valeurStr = Integer.toString(valeur);
        int nbChiffresValeur = valeurStr.length();
        String padding = "";
        for (int i = 0; i < nbChiffres - nbChiffresValeur; i++) {
            padding += "0";
        }
        return padding + valeurStr;
    }

    private String toStringFormat() {
        int nbChiffres = Integer.toString(sup - 1).length();
        String fmt = "%0" + Integer.toString(nbChiffres) + "d";
        return String.format(fmt, valeur);
    }

    @Override
    public String toString() {
        // return this.toStringManuel();
        return this.toStringFormat();
    }
}
