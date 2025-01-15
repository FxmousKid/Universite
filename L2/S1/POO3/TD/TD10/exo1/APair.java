package exo1;

public class APair<T, S> implements Pair<T, S> {
	private T fst;
	private S snd;

	public APair(T fst, S snd) {
		this.fst = fst;
		this.snd = snd;
	}

	public T getFst() {
		return fst;
	}
	
	public S getSnd() {
		return snd;
	}

	public APair<S, T> reverse() {
		return new APair<S, T>(snd, fst);
	}


	public static void main(String[] args) {
		APair<Integer, String> pair = new APair<Integer, String>(1, "Ok");
	}
}
