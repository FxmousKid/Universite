
public class Fruit {
    public String nom; // Class attr "nom"
    public int poids; // Class attr "poids"

    public Fruit(String n, int p) {
        // Public constructor "Fruit"
        this.nom = n;
        this.poids = p;
    }

    static Fruit hybridation(Fruit f1, Fruit f2) {
        Fruit f3 =  new Fruit ("(" + f1.nom + f2.nom + ")", f1.poids + f2.poids);
        return f3;
    }

    public static void afficher(Fruit f1) {
        System.out.println("Ce fruit est un(e) " + f1.nom + " et pèse " + f1.poids + " grammes.");
    } 


    
}