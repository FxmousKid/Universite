package exo2;

// 1. on peut invoquer pour sur les methodes de la classe Object


public class Box<T> {
	private T v;
	public Box(T v) {
		this.v = v;
	}

	public static <S>Box<S> build(S v) {
		return new Box<S>(v);
	}
}
