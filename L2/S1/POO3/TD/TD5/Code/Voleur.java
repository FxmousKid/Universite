public class Voleur extends Guerrier implements Cloneable {
    public static final int pointsVieInitiaux = 150;
    
    public Voleur(String nom, Epee epee, Tenebres tenebres) {
	super(nom, epee, tenebres);
    }
    
    public Voleur(String nom, Gourdin gourdin, Tenebres tenebres) {
	super(nom, gourdin, tenebres);
    }
    
    public int pdvInitiaux() {
	return pointsVieInitiaux;
    }
}

