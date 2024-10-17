public class Tests {
    public static void main(String[] args) throws CloneNotSupportedException {
	Voleur v = new Voleur("Arsene", new Gourdin(), new Tenebres());
	Voleur w = (Voleur) v.clone();
	
	System.out.println(v == w);
	System.out.println(v.getClass() == w.getClass());
	System.out.println(v.getNom() == w.getNom());
	System.out.println(v.getEtat() == w.getEtat());
	System.out.println(v.getPrimaire() == w.getPrimaire());
	System.out.println(v.getSecondaire() == w.getSecondaire());
	System.out.println(v.equals(w));
    }
}
