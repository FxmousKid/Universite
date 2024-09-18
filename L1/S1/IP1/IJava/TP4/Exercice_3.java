public class Exercice_3 {
    Exercice_1 object = new Exercice_1();
    
    public static void main(String args[]) {
        Exercice_1.afficher(fibonacci(5));

    }

    public static Integer[] fibonacci(int n) {

        if (n == 0) { Integer[] res={}; return res;}
        if (n == 1) { Integer[] res={0}; return res;}
        if (n == 2) {Integer[] res={0,1}; return res;}

        Integer[] fib = new Integer[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) { 
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib;
    }

    public static Integer[] append(Integer[] arr, int x) {
        Integer[] mod_arr = new Integer[arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            mod_arr[i] = arr[i];
        }
        mod_arr[arr.length] = x;
        return mod_arr;
    }
}
