package exo3;

public class Box<T extends Number> {
	private T v;

	public Box(T v)  {
		this.v = v;
	}

	public static <S extends Number>Box<S> build(S v) {
		return new Box<S>(v);
	}
}
