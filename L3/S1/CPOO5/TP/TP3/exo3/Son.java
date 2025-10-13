class A {};
class B extends A {};
class C extends B {};
class D extends B {};


class Dad {
	public static void f(A a, A aa) { System.out.println("Dad : A : A"); }

	public static void f(A a, B b) { System.out.println("Dad : A : B"); }
}

public class Son extends Dad {
 public static void f(A a, A aa) { System.out.println("Son : A : A"); }
 public static void f(C c, A a) { System.out.println("Son : C : A"); }

 public static void main(String[] args) {
 f(new B(), new A());
 f(new D(), new A());
 f(new B(), new D());
 f(new A(), new C()); 
 // f(new C(), new C()); ne compile pas vu que dad.f et son.f ont des func candidats a cettesignature
 f(new C(), new B());
}
}