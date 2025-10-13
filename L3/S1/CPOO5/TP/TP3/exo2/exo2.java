package exo2;

class A {
}

class B extends A {
}

class C extends A {
}

public class exo2 {
	public static void main(String[] args) {
		// System.out.println((int) true); cannot cast bool to int
		System.out.println((int) 'a');
		System.out.println((byte) 'a');
		System.out.println((byte) 257);
		System.out.println((char) 98);
		System.out.println((double) 98);
		System.out.println((char) 98.12);
		System.out.println((long) 98.12);
		// System.out.println((boolean) 98.); cannot cast in to bool
		// System.out.println((B) new A()); A doesnt have what B has, but since B extends A, B has everything A has
		// System.out.println((C) new B()); C et B n'ont pas de lien direct
		System.out.println((A) new C());
	}
}