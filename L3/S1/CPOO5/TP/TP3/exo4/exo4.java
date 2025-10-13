package exo4;

public class exo4 {
	static void triBulles(int tab[]) {
		boolean change = false;
		do {
			change = false;
			for (int i = 0; i < tab.length - 1; i++) {
				if (tab[i] > tab[i + 1]) {
					int tmp = tab[i + 1];
					tab[i + 1] = tab[i];
					tab[i] = tmp;
					change = true;
				}
			}
		} while (change);
	}
}