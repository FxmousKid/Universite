import java.util.Iterator;

public class Data {
	private Integer[] data;
	public Data(Integer... data) {
		this.data = data;
	}

	static private void print(Iterator<Integer> i) {
		while (i.hasNext()) {
			System.out.println(i.next() + " ");
		}
		System.out.println();
	}

	public void printEven() {
		class EvenIterator implements Iterator<Integer> {

		}	
	}
}
