import java.util.LinkedList;
import java.lang.Integer;

class Voiture {
    private final int id;
    Voiture(int id) {
	this.id = id;
    }
    public String toString() {
	return Integer.toString(id); 
    }
}

public class Parking {
    private final Voiture[] places;
    private final LinkedList<Integer> libres;

    Parking(int n) {
	places = new Voiture[n];
	libres = new LinkedList<Integer>();
	for (int i = 0; i < n; i++) {
	    libres.add(Integer.valueOf(i));
	}
    }

    public int prendPlace(Voiture v) {
	if (libres.isEmpty()) {
	    return -1;
	}
	int i = libres.removeFirst().intValue();
	places[i] = v;
	return i;
    }

    public Voiture liberePlace(int n) {
	if (n < 0 || n >= places.length || places[n] == null) {
	    return null;
	}
	libres.add(Integer.valueOf(n));
	Voiture v = places[n];
	places[n] = null;
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
	Parking p = new Parking(20);
	for (int i = 0; i < 20; i++) {
	    System.out.println(p.prendPlace(new Voiture(i)));
	}
	System.out.println(p);
	for (int i = 19; i >= 0; i--) {
	    System.out.println(p.liberePlace(i));
	}
    }
}
