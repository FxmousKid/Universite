class Voiture {
    private final int id;
    
    Voiture(int id) {
	this.id = id;
    }
    
    public String toString() {
	return Integer.toString(id); 
    }
}

class Place {
    private Voiture voiture;
    private int suivant;
    
    Place(int suivant) {
	this.suivant = suivant;
    }
    
    Voiture getVoiture() {
	return voiture;
    }
    int getSuivant() {
	return suivant;
    }
    
    void setVoiture(Voiture v) {
	voiture = v;
    }
    void setSuivant(int suivant) {
	this.suivant = suivant;
    }

    void liberer(int suivant) {
	voiture = null;
	this.suivant = suivant;

    }
    public String toString() {
	return voiture.toString(); 
    }

}

public class ParkingPlaces {
    private final Place[] places;
    private int libre;
    ParkingPlaces(int n) {
	places = new Place[n];
	libre = -1;
	for (int i = 0; i < n; i++) {
	    places[i] = new Place(libre);
	    libre = i;
	}
    }

    public int prendPlace(Voiture v) {
	if (libre == -1) {
	    return -1;
	}
	places[libre].setVoiture(v);
	int i = libre;
	libre = places[libre].getSuivant();
	return i;
    }

    public Voiture liberePlace(int n) {
	if (n < 0 || n >= places.length || places[n].getVoiture() == null) {
	    return null;
	}
	Voiture v = places[n].getVoiture();
	places[n].liberer(libre);
	libre = n;
	return v;
    }

    public String toString() {
	String s = "";
	for (int i = 0; i < places.length; i++) {
	    if (places[i] == null) {
		continue;
	    }
	    s += "(" + i + ", " + places[i] + ") ";
	}
	return s;
    }

    
    // TEST
    public static void main(String[] args) {
	ParkingPlaces p = new ParkingPlaces(20);
	for (int i = 0; i < 20; i++) {
	    System.out.println(p.prendPlace(new Voiture(i)));
	}
	System.out.println(p);
	for (int i = 19; i >= 0; i--) {
	    System.out.println(p.liberePlace(i));
	}
    }
}
