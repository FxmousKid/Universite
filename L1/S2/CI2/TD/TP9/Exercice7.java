public class Exercice7 {

	public static int fiboTerminalAux(int n, long acc1, long acc2) {
		if (n == 0)
			return (acc1);
		if (n <= 2)
			return (acc2);

		return (fiboTerminalAux(n - 1, acc2, acc1 + acc2));
	}

	public static int fiboTerminal(int n) {
		return fiboTerminalAux(n, 1, 1);
	}

	public static void main(String[] args) {
		System.out.println("fibo(2) = " + fiboTerminal(5, 1, 1));
	} 
	
}
