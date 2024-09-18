public class Panier {

    public Fruit[] tab;

    public Panier(Fruit[] f) {
        this.tab = f;
    }

    public Panier() {
        this.tab = new Fruit[0];
    }

    public Panier(Fruit f, Panier p) {
        this.tab = new Fruit[1 + p.tab.length]; // 1 for the arg, and the panier.length
        
        for (int i = 0; i < p.tab.length; i ++) {
            this.tab[i] = new Fruit(p.tab[i].nom, p.tab[i].poids);
        }

        this.tab[p.tab.length] = new Fruit(f.nom, f.poids); // add lastly f at the last index
        // J'ai chosis de faire des copies, plus sure que des references.
    }
    
    // J'ai ajouter ce constructeur pour simplifier faire des copies d'objects, car je prefere les copies au lieu des references
    public Panier(Panier p) {
        this.tab = new Fruit[p.tab.length];

        for (int i = 0; i < p.tab.length; i++) {
            this.tab[i] = new Fruit(p.tab[i].nom, p.tab[i].poids);
        }
    }

    public static void afficher(Panier p) {
        for (Fruit f : p.tab) {
            Fruit.afficher(f);
        }
    }

    public static Panier hybridePanier(Fruit f, Panier p) {
        Panier p_copy = new Panier(p);
        
        for (int i = 0; i < p_copy.tab.length; i++) {
            p_copy.tab[i] = Fruit.hybridation(f, p_copy.tab[i]);
        }

        return p_copy;
    }
}
