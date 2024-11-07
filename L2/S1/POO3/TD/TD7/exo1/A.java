public class A {
	private int iA;
	public static int sA;

	public void miA() {}
	
	public static void msA() {}

	public class B {
		private int iB;
		public static final int sB = 42;
		public void miB() {
			miA();
		}
		static void msB() {
			System.out.println("Called from B statically");
		}
	}

	static class C {
		private int iC;
		public static int sC;
		public void miC() {}
		public static void msC() {}
	}
}
