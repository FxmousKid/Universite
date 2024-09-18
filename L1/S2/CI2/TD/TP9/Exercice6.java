public class Exercice6 {

	public static int euclideRecursif(int a, int b) {
		if (b == 0)
			return a;

		return (euclideRecursif(b, a % b));
	}

	public static int euclideIteratif(int a, int b) {
		int tmp;

		while (b != 0) {
			tmp = a;
			a = b;
			b = tmp % b; 
		}
		return a;
	}
	

	public static void main(String[] args) {
		System.out.println("PGCD(25, 20) = " + euclideRecursif(25, 20));	
		System.out.println("PGCD(25, 20) = " + euclideIteratif(25, 20));
	}
}	
