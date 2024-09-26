public class Test {
    public static void main(String[] args) {
        A u = new A(0);
        A v = new A(0);
        System.out.println("u: " + u);
        System.out.println("v: " + v);
        u.g();
        System.out.println("u: " + u);
        v.g();
        System.out.println("v: " + v);
        u.g();
        System.out.println("u: " + u);
    }
}
