package exo4;

public class MotComparable implements Comparable{
	Object mot;

	public MotComparable(Object o) {mot = o;}

	public Object value() {
		return mot;
	}

	public boolean estPlusGrand(Comparable m) {
		if (!(m.value() instanceof String m_value)) {
			throw new IllegalArgumentException("m.value() has to be an instance of String");
		}

		System.out.println("Length = " + m_value);
		return true;
	}

	public static void main(String[] args) {
		MotComparable m = new MotComparable("Coucou");
		MotComparable n = new MotComparable("Salut");
		m.estPlusGrand(n);
	}
}