public class Main {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.C c = new A.C();

		b.miB();
		c.miC();
		A.C.msC();

		System.out.println("a.Sa = " + A.sA);
		System.out.println("b.sB = " + A.B.sB);
		System.out.println("c.sC = " + A.C.sC + "\n");
		
		A.B.msB();
	}
}
