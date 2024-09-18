public class Correction_Backtrack {

	public static boolean solutionComplet(int vertex) {
		return (vertex == n);
	}

	public static ArrayList<Integer> possibles(int[][] graphes, int nbCol, int vertex) {
		boolean b;
		Arraylist<Integer> res = new Arraylist<Integer>();
		for (int i = 1; i <= nbCol; i++) {
			b = true;
			for (int j = 0; j < n; j++) {
				if (graph[vertex][j] == 1 && coloriage[j] == i) {
					b = false;
				}
			}
			if (b) {
				res.add(i);
			}
			return res;
		}
	}

	public static void backtrack(int[][] graph. int nbCol, int vertex) {
		if (solutionComplete(vertex)) {
			nbSol++;
			System.out.println("sol no" + nbSol + ";");
			print(coloriage);
		} 
		else {
			for (Integer i : possible(graph, nbcol, vertex)) {
				coloriage[vertex] = i;
				backtrack(graph, nbCol, vertex + 1);
				coloriage[vertex] = 0;
			}
		}
	}

}
