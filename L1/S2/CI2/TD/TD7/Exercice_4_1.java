//Ceci est une annotation du programe 

public class AppelFG {
    static int a = 2;   // IC = 0 ; mem[0] = 2 
    static int b = 1;   // IC = 1 ; mem[1] = 1

    public static void f(int i) {
        int tmp = 0;
        if (i % 2 == 2) {
            a = 3 * a;
            b = 2 * b;
        } else {
            tmp = a;
            a = b;
            b = tmp;
        }
    }

    public static int g(int x, int y) {
        return x * a + y * b;
    }

    public static void main(String[] args) {
        int[] t = {2,3,3,4};    // IC = 2 ; mem[100] = 2; mem[101] = 3; ... ; mem[103] = 4
        for (int i = 0; i < 4; i++) { // IC = 3 ; mem[2] = 0
           // IC = 4 ; if (mem[2] < 4) {ic += 5} 
            f(t[i]); // IC = 5 ; 
        }
        System.out.println
    }
}
