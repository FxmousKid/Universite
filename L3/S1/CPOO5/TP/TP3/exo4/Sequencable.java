package exo4;

public interface Sequencable {
	public int longeur(); // Renvoie la longueur de la sequence

	public Comparable get(int i); // Renvoie le ieme objet de la sequence

	public void echange(int i, int j); // Echange le ieme object avec le jieme objet

 	// Affiche tout les elements de la sequence
	default void affiche() {
		System.out.println("Objects = [");
		for (int i = 0; i < longeur() - 1; i++) {
			System.out.print(get(i).toString() + ", ");
		}
		System.out.print(get(longeur() - 1).toString());
		System.out.println("]");
	}

	default void triBulles() {
		boolean change = false;
		do {
			change = false;
			for (int i = 0; i < longeur() - 1; i++) {
				if (get(i).estPlusGrand(get(i + 1))) {
					echange(i + 1, i);
					change = true;
				}
			}
		} while (change);

	}
}