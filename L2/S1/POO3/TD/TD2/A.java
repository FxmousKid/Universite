public class A {
    public static int a = 3;
    public int b;
    
    public A (int c) {
        this.b = c;
    }
       
    public void g() {
        a = a+1;
        b = b+1;
    }
    public String toString(){
    return  "a = " + a + ", b = "+ b;     
    }
}
